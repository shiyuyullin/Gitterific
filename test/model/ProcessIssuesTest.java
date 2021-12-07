package model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;
import play.mvc.Result;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Test cases for ProcessIssues
 */
public class ProcessIssuesTest {

    @Mock
    WSClient mockWS = mock(WSClient.class);
    WSRequest mockRequest = mock(WSRequest.class);
    CompletionStage<WSResponse> mockResponse = mock(CompletionStage.class);
    @InjectMocks
    ProcessIssues client = new ProcessIssues(mockWS);

    /**
     * This is the test case for rendering search result
     */
    @Test
    public void RenderResultTest() {
        CompletionStage<List<String>> list = CompletableFuture.completedStage(new ArrayList<String>());
        CompletionStage<Result> result = client.renderResult(list);
        Result actualResult = null;
        try{
            actualResult = result.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("Error occurred when trying to resolve completableFuture");
        }
        assertEquals(OK, actualResult.status());
        assertTrue(contentAsString(actualResult).contains("Statistics"));
    }

    /**
     * This is the test case for retrieve issues as jsonnode
     */
    @Test
    public void GetIssuesAsJsonNodeTest() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode parent = factory.objectNode();
        ObjectNode child = factory.objectNode();
        child.put("title", "this Is A Title");
        parent.set("field", child);
        when(mockWS.url("https://api.github.com/repos/aaa/bbb/issues")).thenReturn(mockRequest);
        when(mockRequest.addHeader("Accept", "application/vnd.github.v3+json")).thenReturn(mockRequest);
        when(mockRequest.get()).thenReturn(mockResponse);
        CompletionStage<JsonNode> listOfTitles =  client.getIssuesAsJsonNode("aaa","bbb");
        assertNull(listOfTitles);

    }

    /**
     * This is the test case for processing jsonnode and retrieve meaningful information
     */
    @Test
    public void GetIssuesTitlesTest() {

        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode parent = factory.objectNode();
        ObjectNode child = factory.objectNode();
        child.put("title", "this Is A Title");
        parent.set("field", child);
        CompletionStage<JsonNode> node = CompletableFuture.completedStage(parent);
        CompletionStage<List<String>> list = client.getIssuesTitles(node);
        List<String> actualList = null;
        try{
            actualList = list.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred when getting completableFuture");
        }
        assertEquals("\"this Is A Title\"", actualList.get(0));

    }

    /**
     * This is the test case for giving a list of string, count how many of them are unique
     */
    @Test
    public void CountingUniqueWordsTest(){

        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("hello--world");
        listOfWords.add("world-%^#@world");
        Map<String,Long> count = client.countUniqueWords(listOfWords);
        assertEquals(Long.valueOf(3),count.get("world"));
        assertNull(count.get("notExists"));
        // case where the argument is null
        Map<String,Long> nullCaseMap = client.countUniqueWords(null);
        assertNull(nullCaseMap.get("any"));
    }

    /**
     * This is the test case for sorting a map based on value of each entry
     */
    @Test
    public void SortWordCountTest(){
        Map<String, Long> map = new HashMap<>();
        map.put("bbb", (long) 3);
        map.put("aaa", (long) 10);
        HashMap<String,Long> newMap = client.sortWordCountDescending(map);
        List<Map.Entry<String, Long>> list = new ArrayList<>(newMap.entrySet());
        // expected result is aaa before bbb
        assertEquals("aaa", list.get(0).getKey());
        // case where the argument is null
        HashMap<String, Long> nullCaseMap = client.sortWordCountDescending(null);
        assertNull(nullCaseMap.get("any"));
    }




}