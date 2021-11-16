package model;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RetrieveSearchResultsTest {

    @Mock
    WSClient mockWS = mock(WSClient.class);
    WSRequest mockRequest = mock(WSRequest.class);
    CompletionStage<WSResponse> mockResponse = mock(CompletionStage.class);
    @InjectMocks
    RetrieveSearchResults client = new RetrieveSearchResults(mockWS);

    @Test
    void SearchForRepoTest(){

    }

}