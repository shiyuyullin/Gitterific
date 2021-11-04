package controllers;

import model.Issues;

import java.util.concurrent.CompletionStage;
import javax.inject.Inject;

import akka.stream.Materializer;

import play.mvc.*;
import play.libs.ws.*;

import model.Issues;

import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject WSClient ws;
    @Inject Materializer materializer;

    public Result index() {
        return ok(views.html.index.render());
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }

    public CompletionStage<Result> issue(){
        Issues client = new Issues(ws);
        return (client.getIssues());
    }

}
