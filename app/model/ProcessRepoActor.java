package model;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ProcessRepoActor extends AbstractActor {


    public static class repoProcess {
        public String author;
        public String repo;
        public ProcessRepo processRepo;

        public repoProcess(String author, String repo) {
            this.author = author;
            this.repo = repo;
            this.processRepo = new ProcessRepo();
        }
    }

    public static Props getProps() {
        return Props.create(ProcessRepoActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        repoProcess.class,
                        repoProcess -> {
                            ActorRef sender = sender();
                            repoProcess.processRepo.process(repoProcess.author, repoProcess.repo)
                                    .thenAccept(result -> sender.tell(result, self()));
                        }
                )
                .build();
    }
}

