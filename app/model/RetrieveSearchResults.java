package model;
import javax.inject.Inject;
import javax.swing.text.html.Option;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.routes;
import play.cache.*;
import play.libs.Json;
import play.mvc.*;
import play.libs.ws.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static play.mvc.Results.*;

public class RetrieveSearchResults implements WSBodyReadables, WSBodyWritables {

    private final WSClient ws;

    @Inject
    public RetrieveSearchResults(WSClient ws){
        this.ws = ws;
    }

    public CompletionStage<JsonNode> getRepoInfoAsJsonNode(String keywords){
        String formattedKeywords = formatKeywordString(keywords);
        return ws.url("https://api.github.com/search/repositories?q=" + formattedKeywords + "&sort:author-date-desc&per_page=10")
                .addHeader("Accept","application/vnd.github.v3+json")
                .get()
                .thenApply(WSResponse::asJson);
    }

    public CompletionStage<Result> searchForRepo(String keywords, String username, CompletionStage<JsonNode> futureJson){

        if(keywords == null || username == null || futureJson == null){
            return CompletableFuture.completedStage(ok(views.html.index.render(null,null)));
        }
        else{
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
            return sortedByCreatedDate.thenApply(repo -> {
                GeneralRepoInfo.addRepoList(username, repo);
                GeneralRepoInfo.addSearchKeywords(username, keywords);
                return ok(views.html.index.render(GeneralRepoInfo.getRepoList(username), GeneralRepoInfo.getSearchKeywords(username)));
            });

        }
    }

    public String formatKeywordString(String keywords){

        if(keywords == null) return "";
        String[] keyword = keywords.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < keyword.length; i++){
            if(i == keyword.length - 1) sb.append(keyword[i]);
            else sb.append(keyword[i]).append("+");
        }
        return sb.toString();
    }

    public CompletionStage<List<GeneralRepoInfo>> sortByDate(CompletionStage<List<GeneralRepoInfo>> listOfRepos){
        CompletionStage<List<GeneralRepoInfo>> sorted =  listOfRepos.thenApply(repos -> repos.stream()
                .sorted(Comparator.comparing(GeneralRepoInfo::getCreatedDate).reversed())
                .collect(Collectors.toList()));
        return sorted;
    }

}
