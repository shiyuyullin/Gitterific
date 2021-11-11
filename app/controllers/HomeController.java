package controllers;

import model.GeneralRepoInfo;
import model.Issues;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;

import akka.stream.Materializer;

import model.Repos;
import model.RetrieveSearchResults;
import play.cache.AsyncCacheApi;
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

    public Result index() {
        List<GeneralRepoInfo> temp = Arrays.asList();
        return ok(views.html.index.render(GeneralRepoInfo.repoList,GeneralRepoInfo.searchKeywords));
    }

    public CompletionStage<Result> issue(){
        Issues client = new Issues(ws);
        return client.renderResult(client.getIssuesTitles());
    }

    public CompletionStage<Result> keyword(Http.Request request){

        DynamicForm requestData = formFactory.form().bindFromRequest(request);
        String keywords = requestData.get("keywords");
        RetrieveSearchResults client = new RetrieveSearchResults(ws);
        return client.searchForRepo(keywords);

    }

    public Result repos(String repo) {
        Repos repos =  new Repos(repo);
        return ok(views.html.repos.render(repos));
    }


}
