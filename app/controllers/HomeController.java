package controllers;

import actor.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import model.*;

import java.util.Optional;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;

import akka.stream.Materializer;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.streams.ActorFlow;
import play.mvc.*;
import play.libs.ws.*;
import scala.compat.java8.FutureConverters;
import actor.ProcessIssuesActor.ProcessIssuesOfRepo;

import static akka.pattern.Patterns.ask;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final ActorRef processIssuesActor;
    private final ActorRef supervisorRSR;
    private final ActorRef processRepoActor;
    private final ActorRef processProfileActor;
    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject WSClient ws;
    @Inject FormFactory formFactory;

    @Inject
    public HomeController(ActorSystem system, Materializer materializer){
        this.actorSystem = system;
        this.materializer = materializer;
        processIssuesActor = system.actorOf(ProcessIssuesActor.getProps());
        processRepoActor = system.actorOf(ProcessRepoActor.getProps());
        processProfileActor = system.actorOf(ProcessProfileActor.getProps());
        supervisorRSR = system.actorOf(SupervisorForRSR.getProps(), "supervisor");

    }


    public Result index(String username, Http.Request request) {
        if(request.session().get("username").equals(Optional.empty())){
            return ok(views.html.index.render(null, null, request)).addingToSession(request, "username", username);
        }
        else{
            return ok(views.html.index.render(GeneralRepoInfo.getRepoList(username),GeneralRepoInfo.getSearchKeywords(username), request));
        }
    }

    public CompletionStage<Result> issue(String author, String repo){
        ProcessIssues client = new ProcessIssues(ws);
        return FutureConverters.toJava(ask(processIssuesActor, new ProcessIssuesOfRepo(client, repo, author), 3000))
                .thenApply(reply -> (Result) reply);
//        return client.renderResult(client.getIssuesTitles(client.getIssuesAsJsonNode(author, repo)));
    }

    public CompletionStage<Result> keyword(Http.Request request){

        DynamicForm requestData = formFactory.form().bindFromRequest(request);
        String keywords = requestData.get("keywords");
        RetrieveSearchResults client = new RetrieveSearchResults(ws);
        return FutureConverters.toJava(ask(supervisorRSR, new SupervisorForRSR.forwardToChild(request.session().get("username").get(), keywords, request, client), 3000))
                .thenApply(reply -> (Result) reply);
    }

    public CompletionStage<Result> repos(String author,String repo) {
        return FutureConverters.toJava(ask(processRepoActor, new ProcessRepoActor.repoProcess(author, repo), 3000))
                .thenApply(reply -> (Result) reply);
//        return ProcessRepo.process(author,repo);
//        Repos repos =  new Repos(repo);
//        List<Repo_issues> repo_issues = repos.issues();
//        return ok(views.html.repos.render(repos, repo_issues));
    }

    public CompletionStage<Result> userProfile(String user) {
        return FutureConverters.toJava(ask(processProfileActor, new ProcessProfileActor.profileProcess(user),3000))
                .thenApply(reply -> (Result) reply);
    }

    public WebSocket socket(){
        return WebSocket.Text.accept(request -> {
            return ActorFlow.actorRef(actorRef -> DisplayActor.getProps(actorRef, request.session().get("username").get()), actorSystem, materializer);
        });
    }

}
