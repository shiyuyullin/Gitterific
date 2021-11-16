package model;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.*;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProcessIssuesTest {

    @Mock
    WSClient mockWS = mock(WSClient.class);
    WSRequest mockRequest = mock(WSRequest.class);
    CompletionStage<WSResponse> mockResponse = mock(CompletionStage.class);
    CompletionStage<JsonNode> mockJsonNode = mock(CompletionStage.class);
    CompletionStage<List<String>> mockList = mock(CompletionStage.class);
    @InjectMocks
    ProcessIssues client = new ProcessIssues(mockWS);


    @Test
    void RenderResultTest(){
        when(mockList.thenApply(Function.identity())).thenReturn(null);
        assertNull(client.renderResult(mockList));
    }

    @Test
    void GetIssuesAsJsonNodeTest() throws ExecutionException, InterruptedException {
        when(mockWS.url("https://api.github.com/repos/aaa/bbb/issues")).thenReturn(mockRequest);
        when(mockRequest.addHeader("Accept", "application/vnd.github.v3+json")).thenReturn(mockRequest);
        when(mockRequest.get()).thenReturn(mockResponse);
        when(mockResponse.thenApply(WSResponse::asJson)).thenReturn(mockJsonNode);
        CompletionStage<JsonNode> listOfTitles =  client.getIssuesAsJsonNode("aaa","bbb");
        assertNull(listOfTitles);
    }

    @Test
    void GetIssuesTitlesTest() throws ExecutionException, InterruptedException {

        CompletionStage<List<String>> issueTitles = client.getIssuesTitles(mockJsonNode);
        assertNull(issueTitles);

    }

    @Test
    void CountingUniqueWordsTest(){

        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("hello--world");
        listOfWords.add("world-%^#@world");
        Map<String,Long> count = client.countUniqueWords(listOfWords);
        assertEquals(3,count.get("world"));
        assertNull(count.get("notExists"));
        // case where the argument is null
        Map<String,Long> nullCaseMap = client.countUniqueWords(null);
        assertNull(nullCaseMap.get("any"));
    }

    @Test
    void SortWordCountTest(){
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
