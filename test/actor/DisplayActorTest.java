package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import model.ProcessIssues;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class DisplayActorTest {


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
        TestKit testProbe = new TestKit(system);
        ActorRef displayActor = system.actorOf(DisplayActor.getProps(testProbe.getRef(), "username"));
        displayActor.tell("here is a message", testProbe.getRef());
        String message = testProbe.expectMsg("received");
        assertEquals("received", message);

    }








}