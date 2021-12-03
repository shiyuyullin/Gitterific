package actor;

import akka.actor.*;
import model.ProcessIssues;


public class ProcessIssuesActor extends AbstractActor {

    public static class ProcessIssuesOfRepo{
        public String repoName;
        public String authorName;
        public ProcessIssues client;

        public ProcessIssuesOfRepo(ProcessIssues client, String repoName, String authorName){
            this.repoName = repoName;
            this.authorName = authorName;
            this.client = client;
        }
    }

    public static Props getProps(){
        return Props.create(ProcessIssuesActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        ProcessIssuesOfRepo.class,
                        msg -> {
                            // For some reason, if we don't store the ActorRef here
                            // and if we just call the method sender() inside thenAccept()
                            // the ActorRef of sender is wrong
                            ActorRef sender = sender();
                            msg.client.renderResult(msg.client.getIssuesTitles(msg.client.getIssuesAsJsonNode(msg.authorName, msg.repoName)))
                                    .thenAccept(result -> sender.tell(result, self()));
                        })
                .build();
    }






}
