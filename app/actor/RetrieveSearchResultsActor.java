package actor;

import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;
import model.RetrieveSearchResults;
import play.mvc.Http;

public class RetrieveSearchResultsActor extends AbstractActorWithTimers {

    public static class GetRepo{
        private String username;
        private String keywords;
        private Http.Request request;
        private RetrieveSearchResults client;

        public GetRepo(String username, String keywords, Http.Request request, RetrieveSearchResults client){
            this.username = username;
            this.keywords = keywords;
            this.request = request;
            this.client = client;
        }
    }

    public static class UpdateRepo{
        private String keywords;
        public UpdateRepo(String keywords){
            this.keywords = keywords;
        }
    }

    private RetrieveSearchResults client;

    public static Props getProps(){
        return Props.create(RetrieveSearchResultsActor.class);
    }

    @Override
    public Receive createReceive(){

        return receiveBuilder()
                .match(GetRepo.class,
                        msg -> {
                            client = msg.client;
                            ActorRef sender = sender();
                            msg.client.searchForRepo(msg.keywords, msg.username, msg.request, msg.client.getRepoInfoAsJsonNode(msg.keywords))
                                    .thenAccept(result -> sender.tell(result, self()));
                        })
                .match(String.class, msg ->{
                    System.out.println("received hello from" + sender());
                })
                .match(UpdateRepo.class, msg->{
                    ActorRef sender = sender();
                    client.getRepoAsAList(msg.keywords).thenAccept(listOfRepos ->{
                        sender.tell(new DisplayActor.newRepoMessage(listOfRepos, msg.keywords), self());
                    });
                })
                .build();

    }




}
