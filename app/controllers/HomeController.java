package controllers;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.fasterxml.jackson.databind.JsonNode;
import model.*;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;

import akka.stream.Materializer;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import play.libs.ws.*;
import scala.compat.java8.FutureConverters;
import model.ProcessIssuesActor.ProcessIssuesOfRepo;


import static akka.pattern.Patterns.ask;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final ActorRef processIssuesActor;

    @Inject WSClient ws;
    @Inject Materializer materializer;
    @Inject FormFactory formFactory;

    @Inject
    public HomeController(ActorSystem system){
        processIssuesActor = system.actorOf(ProcessIssuesActor.getProps());
    }


    public Result index(String username, Http.Request request) {
        if(request.session().get("username").equals(Optional.empty())){
            return ok(views.html.index.render(null, null)).addingToSession(request, "username", username);
        }
        else{
            return ok(views.html.index.render(GeneralRepoInfo.getRepoList(username),GeneralRepoInfo.getSearchKeywords(username)));
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
        return client.searchForRepo(keywords, request.session().get("username").get(), client.getRepoInfoAsJsonNode(keywords));
    }

    public CompletionStage<Result> repos(String author,String repo) {
        return ProcessRepo.process(author,repo);
//        Repos repos =  new Repos(repo);
//        List<Repo_issues> repo_issues = repos.issues();
//        return ok(views.html.repos.render(repos, repo_issues));
    }

    public CompletionStage<Result> userProfile(String user) {
        return ProcessProfile.processUsers(user);
    }

}
