package model;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import play.libs.ws.*;

import java.util.*;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static play.mvc.Results.ok;

public class RetrieveSearchResults implements WSBodyReadables, WSBodyWritables {

    private final WSClient ws;

    @Inject
    public RetrieveSearchResults(WSClient ws){
        this.ws = ws;
    }


    public CompletionStage<Result> searchForRepo(String keywords){

        String formattedKeywords = formatKeywordString(keywords);
        WSRequest request = ws.url("https://api.github.com/search/repositories?q=" + formattedKeywords + "&sort:author-date-desc&per_page=10")
                .addHeader("Accept","application/vnd.github.v3+json");

        CompletionStage<WSResponse> futureResponse = request.get();
        CompletionStage<JsonNode> futureJson = futureResponse.thenApply(WSResponse::asJson);
        CompletionStage<JsonNode> items = futureJson.thenApply(jsonNode -> jsonNode.get("items"));
        CompletionStage<List<GeneralRepoInfo>> listOfRepos = items.thenApply(nodes -> StreamSupport.stream(nodes.spliterator(), false)
                .map(node -> new GeneralRepoInfo(
                        node.get("owner").get("login").toString(),
                        node.get("name").toString(),
                        node.get("topics").toString(),
                        node.get("created_at").toString()
                        )
                    )
                .collect(Collectors.toList()));
        CompletionStage<List<GeneralRepoInfo>> sortedByCreatedDate =  sortByDate(listOfRepos);
        return sortedByCreatedDate.thenApply(repo -> ok(views.html.index.render(repo,keywords)));
    }

    private String formatKeywordString(String keywords){
        String[] keyword = keywords.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < keyword.length; i++){
            sb.append(keyword[i]).append("+");
        }
        return sb.toString();
    }

    private CompletionStage<List<GeneralRepoInfo>> sortByDate(CompletionStage<List<GeneralRepoInfo>> listOfRepos){
        CompletionStage<List<GeneralRepoInfo>> sorted =  listOfRepos.thenApply(repos -> repos.stream()
                .sorted(Comparator.comparing(GeneralRepoInfo::getCreatedDate).reversed())
                .collect(Collectors.toList()));
        return sorted;
    }

}
