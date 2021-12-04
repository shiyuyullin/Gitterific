package actor;

import akka.actor.*;
import model.ProcessProfile;

public class ProcessProfileActor extends AbstractActor {

    public static class profileProcess {
        public String user;
        public ProcessProfile processProfile;

        public profileProcess(String user) {
            this.user = user;
            this.processProfile = new ProcessProfile();
        }
    }

    public static Props getProps() {
        return Props.create(ProcessProfileActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        profileProcess.class,
                        profileProcess -> {
                            ActorRef sender = sender();
                            profileProcess.processProfile.processUsers(profileProcess.user)
                                    .thenAccept(result -> sender.tell(result,self()));
                        }
                ).match(String.class, msg -> getSender().tell("received", self())).build();
    }
}
