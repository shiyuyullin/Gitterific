package model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Http;
import play.mvc.Result;
import static play.test.Helpers.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for RetrieveSearchResults
 */
public class RetrieveSearchResultsTest{

    @Mock
    WSClient mockWS = mock(WSClient.class);
    WSRequest mockRequest = mock(WSRequest.class);
    CompletionStage<WSResponse> mockResponse = mock(CompletionStage.class);
    Http.Request mockHTTPRequest = mock(Http.Request.class);
    @InjectMocks
    RetrieveSearchResults client = new RetrieveSearchResults(mockWS);

    /**
     * This is the test case for retrieving information by calling an external api
     * Since we do not want to call the live api, the test will mock results for each step
     */
    @Test
    public void GetRepoInfoAsJsonNodeTest(){
        when(mockWS.url("https://api.github.com/search/repositories?q=java&sort=updated")).thenReturn(mockRequest);
        when(mockWS.url("https://api.github.com/search/repositories?q=&sort=updated")).thenReturn(mockRequest);
        when(mockRequest.addHeader("Accept","application/vnd.github.v3+json")).thenReturn(mockRequest);
        when(mockRequest.get()).thenReturn(mockResponse);
        assertNull(client.getRepoInfoAsJsonNode("java"));
        assertNull(client.getRepoInfoAsJsonNode(null));
    }

    /**
     * This is the test case for getting information of a repository from a jsonNode response
     * we create a fake jsonNode object by ourselves and check if the method could get the info
     * we want at the end
     */
    @Test
    public void SearchForRepoTest(){
        // create a mock JsonNode
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode parent = factory.objectNode();
        ObjectNode index = factory.objectNode();
        ObjectNode child = factory.objectNode();
        ObjectNode owner = factory.objectNode();
        owner.put("login", "dtrupenn");
        child.put("name", "Tetris");
        child.put("topics", "");
        child.put("created_at", "2012-01-01T00:31:50Z");
        child.set("owner", owner);
        index.set("0", child);
        parent.set("items", index);
        CompletionStage<Result> result = client.searchForRepo("java", "user1", mockHTTPRequest, CompletableFuture.completedStage(parent));
        Result actualResult = null;
        try{
            actualResult = result.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred");
        }
        assertEquals(303, actualResult.status());
        assertFalse(contentAsString(actualResult).contains("Tetris"));
        // when either keywords are null or username is null
        CompletionStage<Result> result2 = client.searchForRepo(null,"user1", mockHTTPRequest, CompletableFuture.completedStage(parent));
        Result actualResult2 = null;
        try{
            actualResult2 = result2.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred");
        }
        assertEquals(200, actualResult2.status());
        assertFalse(contentAsString(actualResult2).contains("Tetris"));
        // when user entered nothing but clicked search
        CompletionStage<Result> result3 = client.searchForRepo("","user1", mockHTTPRequest, CompletableFuture.completedStage(parent));
        Result actualResult3 = null;
        try{
            actualResult3 = result3.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred");
        }
        assertEquals(200, actualResult3.status());
        assertTrue(contentAsString(actualResult3).contains("Tetris"));
    }

    /**
     * This is the test case for formatting an input string
     */
    @Test
    public void FormatKeywordStringTest(){

        String keywords1 = "java ai";
        String formatted = client.formatKeywordString(keywords1);
        assertEquals("java+ai", formatted);
        String keywords2 = "python";
        assertEquals("python", client.formatKeywordString(keywords2));
        String keywords3 = null;
        assertEquals("", client.formatKeywordString(keywords3));
    }


}