package model;

import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.mvc.Http;

import java.util.HashMap;

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

    public static class RegisterMessage{

    }

    private HashMap<String, ActorRef> displayActors = new HashMap<>();

    public static Props getProps(){
        return Props.create(RetrieveSearchResultsActor.class);
    }

    @Override
    public Receive createReceive(){

        return receiveBuilder()
                .match(GetRepo.class,
                        msg -> {
                            ActorRef sender = sender();
                            msg.client.searchForRepo(msg.keywords, msg.username, msg.request, msg.client.getRepoInfoAsJsonNode(msg.keywords))
                                    .thenAccept(result -> sender.tell(result, self()));
                        })
                .build();

    }




}
