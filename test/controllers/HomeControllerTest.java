package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

public class HomeControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/user");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }
    @Test
    public void testRepo() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/repo/gto76/python-cheatsheet");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }


    @Test
    public void userProfile() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/user/ninanee");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }
}
