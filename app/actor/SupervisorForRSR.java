package actor;

import akka.actor.*;
import model.RetrieveSearchResults;
import play.mvc.Http;
import play.mvc.Result;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeoutException;

import static akka.actor.SupervisorStrategy.restart;
import static akka.actor.SupervisorStrategy.stop;

public class SupervisorForRSR extends AbstractActor {

    ActorRef child;
    ActorRef application;

    public static class forwardToChild{
        private String username;
        private String keywords;
        private Http.Request request;
        private RetrieveSearchResults client;

        public forwardToChild(String username, String keywords, Http.Request request, RetrieveSearchResults client){
            this.username = username;
            this.keywords = keywords;
            this.request = request;
            this.client = client;
        }
    }

    @Override
    public void preStart(){

        child = getContext().actorOf(RetrieveSearchResultsActor.getProps(), "retrieveActor");

    }

    public static Props getProps(){
        return Props.create(SupervisorForRSR.class);
    }


    @Override
    public Receive createReceive(){

        return receiveBuilder()
                .match(String.class, msg ->{
                    System.out.println(getSelf());
                    System.out.println(child);
                })
                .match(forwardToChild.class, msg -> {
                    application = getSender();
                    child.tell(new RetrieveSearchResultsActor.GetRepo(msg.username, msg.keywords, msg.request, msg.client), getSelf());
                })
                .match(Result.class, msg -> {
                    application.tell(msg, getSelf());
                })
                .build();
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    private static SupervisorStrategy strategy =
            new OneForOneStrategy(10, Duration.create("1 minute"),
                    t -> {
                        if (t instanceof TimeoutException) {
                            return restart();
                        } else {
                            return stop();
                        }
                    });



}
