package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RetrieveSearchResultsActorTest {


    static ActorSystem system;

    @BeforeAll
    public static void setup(){
        system = ActorSystem.create();
    }

    @AfterAll
    public static void shutdown(){
        TestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void testProcessIssuesActor(){
        System.out.println("aaaaaaa");
        TestKit testProbe = new TestKit(system);
        ActorRef retrieveSearchResultsActor = system.actorOf(RetrieveSearchResultsActor.getProps());
        retrieveSearchResultsActor.tell("here is a message", testProbe.getRef());
        String message = testProbe.expectMsg("received hello from" + testProbe.getRef());
        assertEquals("received hello from" + testProbe.getRef(), message);

    }








}