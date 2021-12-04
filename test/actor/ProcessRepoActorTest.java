package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import model.ProcessRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ProcessRepoActorTest {


    @Mock
    ProcessRepo client = mock(ProcessRepo.class);

//    processRepoActor = system.actorOf(ProcessRepoActor.getProps());

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
    public void testProcessRepoActor(){


        TestKit testProbe = new TestKit(system);
        ActorRef processRepoActor = system.actorOf(ProcessRepoActor.getProps());
        processRepoActor.tell("here is a message", testProbe.getRef());
        String message = testProbe.expectMsg("received");
        assertEquals("received", message);


    }

}