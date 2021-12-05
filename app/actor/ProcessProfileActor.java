package actor;

import akka.actor.*;
import model.ProcessProfile;

/**
 * Tests for the ProcessProfileActor
 * @author Yun Ni
 */
public class ProcessProfileActor extends AbstractActor {

    public static class profileProcess {
        public String user;
        public ProcessProfile processProfile;

        /***
         * the ctor of the class
         * @param user
         */
        public profileProcess(String user) {
            this.user = user;
            this.processProfile = new ProcessProfile();
        }
    }

    /***
     * this action is used to create the ProfileActor for handling the request of the User
     * @return Props
     */
    public static Props getProps() {
        return Props.create(ProcessProfileActor.class);
    }

    /***
     * this action is used to send the message.
     * @return Receive
     */
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
