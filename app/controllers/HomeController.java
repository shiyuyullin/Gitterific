package controllers;

import model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;

import akka.stream.Materializer;

import org.checkerframework.checker.units.qual.C;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;
import play.libs.ws.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject WSClient ws;
    @Inject Materializer materializer;
    @Inject FormFactory formFactory;

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
        return client.renderResult(client.getIssuesTitles(author,repo));
    }

    public CompletionStage<Result> keyword(Http.Request request){

        System.out.println(request.session().get("username"));
        DynamicForm requestData = formFactory.form().bindFromRequest(request);
        String keywords = requestData.get("keywords");
        RetrieveSearchResults client = new RetrieveSearchResults(ws);
        return client.searchForRepo(keywords, request.session().get("username").get());

    }

    public CompletionStage<Result> repos(String repo) {
        return ProcessRepo.process(repo);
//        Repos repos =  new Repos(repo);
//        List<Repo_issues> repo_issues = repos.issues();
//        return ok(views.html.repos.render(repos, repo_issues));
    }

    public CompletionStage<Result> userProfile(String user) {
//        Profile users =  new Profile(user);
        return ProcessProfile.processUsers(user);
    }

}
