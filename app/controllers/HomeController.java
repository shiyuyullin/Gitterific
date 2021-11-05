package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.Issues;

import java.net.http.HttpRequest;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;

import akka.stream.Materializer;

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
        return ok(views.html.index.render());
    }

    public CompletionStage<Result> issue(){
        Issues client = new Issues(ws);
        return (client.getIssues());
    }

    public Result keyword(Http.Request request){

        DynamicForm requestData = formFactory.form().bindFromRequest(request);
        String temp = requestData.get("keywords");
        return ok(temp);

    }


}
