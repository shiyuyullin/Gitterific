package model;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

import static org.junit.jupiter.api.Assertions.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;

/***
 * this class is for testing the ProcessProfile
 * @user Yun Ni
 */
class ProcessProfileTest {

    /***
     *for testing the processUsers Method
     */
    @Test
    void processUsers() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode parent = factory.objectNode();
        ObjectNode index = factory.objectNode();
        ObjectNode child = factory.objectNode();
        ObjectNode owner = factory.objectNode();
        owner.put("login", "ninanee");
        child.put("name", "Yun Ni");
        child.put("followers", "4");
        child.put("following", "6");
        child.put("html_url", "https://github.com/ninanee");
        child.put("id", "71697803");
        child.put("location", "Montreal, QC");
        child.put("email", "null");
        child.put("company", "null");
        child.set("owner", owner);
        index.set("0", child);
        parent.set("items", index);
        CompletionStage<Result> result = ProcessProfile.processUsers("ninanee");
        Result actualResult = null;
        try{
            actualResult = result.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred");
        }
        assertEquals(OK, actualResult.status());
    }

    @Test
    void generateJN() {
    }
}