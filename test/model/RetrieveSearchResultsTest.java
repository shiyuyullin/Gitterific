package model;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Result;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RetrieveSearchResultsTest{

    @Mock
    WSClient mockWS = mock(WSClient.class);
    WSRequest mockRequest = mock(WSRequest.class);
    CompletionStage<WSResponse> mockResponse = mock(CompletionStage.class);
    @InjectMocks
    RetrieveSearchResults client = new RetrieveSearchResults(mockWS);

    @Test
    void GetRepoInfoAsJsonNodeTest(){
        when(mockWS.url("https://api.github.com/search/repositories?q=java&per_page=10")).thenReturn(mockRequest);
        when(mockWS.url("https://api.github.com/search/repositories?q=&per_page=10")).thenReturn(mockRequest);
        when(mockRequest.addHeader("Accept","application/vnd.github.v3+json")).thenReturn(mockRequest);
        when(mockRequest.get()).thenReturn(mockResponse);
        assertNull(client.getRepoInfoAsJsonNode("java"));
        assertNull(client.getRepoInfoAsJsonNode(null));
    }

    @Test
    void SearchForRepoTest(){
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
        CompletionStage<Result> result = client.searchForRepo("java", "user1", CompletableFuture.completedStage(parent));
        Result actualResult = null;
        try{
            actualResult = result.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred");
        }
        assertEquals(OK, actualResult.status());
        assertTrue(contentAsString(actualResult).contains("Tetris"));
        // when either keywords are null or username is null
        CompletionStage<Result> result2 = client.searchForRepo(null,"user1", CompletableFuture.completedStage(parent));
        Result actualResult2 = null;
        try{
            actualResult2 = result2.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred");
        }
        assertEquals(OK, actualResult2.status());
        assertFalse(contentAsString(actualResult2).contains("Tetris"));
    }

    @Test
    void FormatKeywordStringTest(){

        String keywords1 = "java ai";
        String formatted = client.formatKeywordString(keywords1);
        assertEquals("java+ai", formatted);
        String keywords2 = "python";
        assertEquals("python", client.formatKeywordString(keywords2));
        String keywords3 = null;
        assertEquals("", client.formatKeywordString(keywords3));

    }

    @Test
    void SortByDateTest(){
        List<GeneralRepoInfo> list = new ArrayList<>();
        list.add(new GeneralRepoInfo("alan", "name2", "topics2", "\"2015-03-12T10:12:20Z\""));
        list.add(new GeneralRepoInfo("shiyu", "name1", "topics1", "\"2018-08-29T17:15:57Z\""));
        CompletionStage<List<GeneralRepoInfo>> futureSortedList1 = client.sortByDate(CompletableFuture.completedStage(list));
        List<GeneralRepoInfo> sortedList1 = null;
        try{
            sortedList1 = futureSortedList1.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred");
        }
        assertEquals("shiyu", sortedList1.get(0).getAuthorName());

        CompletionStage<List<GeneralRepoInfo>> futureSortedList2 = client.sortByDate(null);
        List<GeneralRepoInfo> sortedList2 = null;
        try{
            sortedList2 = futureSortedList2.toCompletableFuture().get();
        }
        catch (Exception e){
            System.out.println("error occurred");
        }
        assertEquals(0, sortedList2.size());
    }





}