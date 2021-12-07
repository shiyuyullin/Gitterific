//package controllers;
//
//import org.junit.Test;
//import play.Application;
//import play.inject.guice.GuiceApplicationBuilder;
//import play.mvc.Http;
//import play.mvc.Result;
//import play.test.WithApplication;
//
//import static org.junit.Assert.assertEquals;
//import static play.mvc.Http.Status.OK;
//import static play.test.Helpers.*;
//
//public class HomeControllerTest extends WithApplication {
//
//    @Override
//    protected Application provideApplication() {
//        return new GuiceApplicationBuilder().build();
//    }
//
//    @Test
//    public void testIndex() {
//        Http.RequestBuilder request = new Http.RequestBuilder()
//                .method(GET)
//                .uri("/user");
//
//        Result result = route(app, request);
//        assertEquals(OK, result.status());
//
//        request = new Http.RequestBuilder()
//                .method(GET)
//                .uri("/user").session("username", "user");
//
//        result = route(app, request);
//        assertEquals(OK, result.status());
//    }
//    @Test
//    public void testRepo() {
//        Http.RequestBuilder request = new Http.RequestBuilder()
//                .method(GET)
//                .uri("/repo/gto76/python-cheatsheet");
//
//        Result result = route(app, request);
//        assertEquals(OK, result.status());
//    }
//
//
//    @Test
//    public void userProfile() {
//        Http.RequestBuilder request = new Http.RequestBuilder()
//                .method(GET)
//                .uri("/user/ninanee");
//
//        Result result = route(app, request);
//        assertEquals(OK, result.status());
//    }
//
//    @Test
//    public void issueTest(){
//        Http.RequestBuilder request = new Http.RequestBuilder()
//                .method(GET)
//                .uri("/issue/octocat/hello-world");
//
//        Result result = route(app, request);
//        assertEquals(OK, result.status());
//    }
//
//    @Test
//    public void keywordTest(){
//        Http.RequestBuilder request = new Http.RequestBuilder()
//                .method(POST)
//                .uri("/").session("username", "user1");
//
//        Result result = route(app, request);
//        assertEquals(OK, result.status());
//    }
//
//}
