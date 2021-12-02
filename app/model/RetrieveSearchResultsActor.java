package model;

import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;

public class RetrieveSearchResultsActor extends AbstractActorWithTimers {

    public static class GetRepo{
        private String username;
        private String keywords;
        private RetrieveSearchResults client;

        public GetRepo(String username, String keywords, RetrieveSearchResults client){
            this.username = username;
            this.keywords = keywords;
            this.client = client;
        }


    }

    public static Props getProps(){
        return Props.create(RetrieveSearchResultsActor.class);
    }

    @Override
    public Receive createReceive(){

        return receiveBuilder()
                .match(GetRepo.class,
                        msg -> {
                            ActorRef sender = sender();
                            msg.client.searchForRepo(msg.keywords, msg.username, msg.client.getRepoInfoAsJsonNode(msg.keywords))
                                    .thenAccept(result -> sender.tell(result, self()));
                        })
                .build();

    }




}
