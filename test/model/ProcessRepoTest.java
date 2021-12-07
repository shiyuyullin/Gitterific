//package model;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.node.JsonNodeFactory;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import junit.framework.TestCase;
//import org.junit.Test;
//import play.mvc.Result;
//
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.CompletionStage;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static play.mvc.Http.Status.OK;
//import static play.test.Helpers.contentAsString;
//
//public class ProcessRepoTest extends TestCase {
//
//
//
//
//    @Test
//    public void testProcess() {
//        JsonNodeFactory factory = JsonNodeFactory.instance;
//        ObjectNode parent = factory.objectNode();
//        ObjectNode index = factory.objectNode();
//        ObjectNode child = factory.objectNode();
//        ObjectNode owner = factory.objectNode();
////        node.path("id").asText(),
////                        node.path("owner").path("login").asText(),
////                        node.path("name").asText(),
////                        node.path("topics").toString(),
////                        node.path("description").asText(),
////                        node.path("default_branch").asText(),
////                        node.path("created_at").toString(),
////                        node.path("updated_at").toString(),
////                        node.path("pushed_at").toString(),
////                        node.path("visibility").asText()
//        owner.put("login", "wakaleo");
//        child.put("name", "game-of-life");
//        child.put("topics", "");
//        child.put("description", "Demo application for the 'Jenkins: The Definitive Guide' book");
//        child.put("default_branch", "master");
//        child.put("created_at", "2011-05-04T05:44:07Z");
//        child.put("updated_at", "2021-10-30T02:40:05Z");
//        child.put("pushed_at", "2021-09-30T23:04:44Z");
//        child.put("visibility", "public");
//        child.set("owner", owner);
//        index.set("0", child);
//        parent.set("items", index);
//        CompletionStage<Result> result = ProcessRepo.process("wakaleo","game-of-life");
//        Result actualResult = null;
//        try{
//            actualResult = result.toCompletableFuture().get();
//        }
//        catch (Exception e){
//            System.out.println("error occurred");
//        }
//        assertEquals(OK, actualResult.status());
//        assertTrue(contentAsString(actualResult).contains("game-of-life"));
//    }
//
//
//    @org.junit.jupiter.api.Test
//    void generateJN() {
//
//
//    }
//}