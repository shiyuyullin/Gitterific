package model;

import akka.actor.*;
import akka.japi.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Result;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


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
                        hello -> {
                            // For some reason, if we don't store the ActorRef here
                            // and if we just call the method sender() inside thenAccept()
                            // the ActorRef of sender is wrong
                            ActorRef sender = sender();
                            hello.client.renderResult(hello.client.getIssuesTitles(hello.client.getIssuesAsJsonNode(hello.authorName, hello.repoName)))
                                    .thenAccept(result -> sender.tell(result, self()));
                        })
                .build();
    }






}
