package actor;

import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;
import model.GeneralRepoInfo;
import scala.concurrent.duration.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DisplayActor extends AbstractActorWithTimers {

    public static class UpdateMessage{

    }

    public static class newRepoMessage{
        private List<GeneralRepoInfo> repoInfo;
        private String keywords;
        public newRepoMessage(List<GeneralRepoInfo> repoInfo, String keywords){
            this.repoInfo = repoInfo;
            this.keywords = keywords;
        }

    }

    private final ActorRef webSocket;
    private String username;

    public DisplayActor(ActorRef webSocket, String username){
        this.webSocket = webSocket;
        // we could use the username to access
        // what are the keywords that this user have searched
        // what are the repo that was retrieved by using that keywords
        this.username = username;
    }

    public static Props getProps(ActorRef out, String username){
        return Props.create(DisplayActor.class, out, username);
    }

    @Override
    public void preStart() {
        getTimers().startPeriodicTimer("Timer", new UpdateMessage(), Duration.create(10, TimeUnit.SECONDS));
    }

    @Override
    public Receive createReceive(){

        return receiveBuilder()
                .match(UpdateMessage.class, msg -> {
                    if(GeneralRepoInfo.getSearchKeywords(username)!=null && GeneralRepoInfo.getSearchKeywords(username).size()>=1){
                        for(String keywords : GeneralRepoInfo.getSearchKeywords(username)){
                            context().actorSelection("/user/supervisor/retrieveActor")
                                    .tell(new RetrieveSearchResultsActor.UpdateRepo(keywords), self());
                        }
                    }
                })
                .match(newRepoMessage.class, msg -> {
//                    System.out.println(msg.repoInfo);
                    // Check if there are any new repos
                    int index = GeneralRepoInfo.getSearchKeywords(username).indexOf(msg.keywords);
                    List<GeneralRepoInfo> oldRepoInfo = GeneralRepoInfo.getRepoList(username).get(index);
                    // Start comparing between the repoInfo we just retrieved and the old repo info
                    List<GeneralRepoInfo> newRepoInfo = new ArrayList<>();
                    for(int i = 0; i < msg.repoInfo.size(); i++){
                        if(!GeneralRepoInfo.contains(msg.repoInfo.get(i), oldRepoInfo)) {
                            newRepoInfo.add(msg.repoInfo.get(i));
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(msg.keywords).append("\n");
                    for(GeneralRepoInfo repo : newRepoInfo){
                        sb.append(repo).append("\n");
                        // Add the new repos into local storage(cache them)
                        oldRepoInfo.add(repo);
                    }
                    webSocket.tell(sb.toString(), self());
                })
                .match(String.class, msg ->{
                    sender().tell("received",self());
                })
                .build();
    }




}
