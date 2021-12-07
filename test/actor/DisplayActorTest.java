package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class DisplayActorTest {


    static ActorSystem system;

    @BeforeClass
    public static void setup(){
        system = ActorSystem.create();
    }

    @AfterClass
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