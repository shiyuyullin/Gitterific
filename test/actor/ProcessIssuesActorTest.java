package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import model.ProcessIssues;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import akka.testkit.javadsl.TestKit;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProcessIssuesActorTest {

    @Mock
    ProcessIssues client = mock(ProcessIssues.class);

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
        ActorRef processIssuesActor = system.actorOf(ProcessIssuesActor.getProps());
        processIssuesActor.tell("here is a message", testProbe.getRef());
        String message = testProbe.expectMsg("received");
        assertEquals("received", message);

    }








}