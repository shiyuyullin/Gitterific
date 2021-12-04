package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import model.ProcessProfile;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ProcessProfileActorTest {

    @Mock
    ProcessProfile profile = mock(ProcessProfile.class);

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
    public void testProcessProfileActor() {
        TestKit testProbe = new TestKit(system);
        ActorRef processProfileActor = system.actorOf(ProcessProfileActor.getProps());
        processProfileActor.tell(new ProcessProfileActor.profileProcess("ni"), testProbe.getRef());
        processProfileActor.tell("message", testProbe.getRef());
        String message = testProbe.expectMsg("received");
        assertEquals("received", message);
    }

}