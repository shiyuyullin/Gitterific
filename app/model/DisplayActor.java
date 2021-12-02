package model;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class DisplayActor extends AbstractActor {

    public static class DisplayMessage{

    }

    private final ActorRef webSocket;

    public DisplayActor(ActorRef webSocket){
        this.webSocket = webSocket;
    }

    public static Props getProps(ActorRef out){
        System.out.println("create actor");
        return Props.create(DisplayActor.class, out);
    }

    @Override
    public Receive createReceive(){

        return receiveBuilder()
                .match(String.class, msg -> {
                    System.out.println("Got message: " + msg);
                    webSocket.tell("message---------",self());
                })
                .build();
    }




}
