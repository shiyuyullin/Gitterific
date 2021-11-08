package model;


import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;
import play.libs.ws.*;

import java.util.*;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static play.mvc.Results.ok;

public class RepositoryInfo implements WSBodyReadables, WSBodyWritables {

    private final WSClient ws;

    @Inject
    public RepositoryInfo(WSClient ws){
        this.ws = ws;
    }


    public CompletionStage<Result> searchForRepo(String keywords){

        String formattedKeywords = formatKeywordString(keywords);
        WSRequest request = ws.url("https://api.github.com/search/repositories?q=" + formattedKeywords + "&per_page=10")
                .addHeader("Accept","application/vnd.github.v3+json");

        CompletionStage<WSResponse> futureResponse = request.get();
        CompletionStage<JsonNode> futureJson = futureResponse.thenApply(WSResponse::asJson);
        CompletionStage<JsonNode> items = futureJson.thenApply(jsonNode -> jsonNode.get("items"));
        CompletionStage<List<Repository>> listOfRepos = items.thenApply(nodes -> StreamSupport.stream(nodes.spliterator(), false)
                .map(node -> new Repository(node.get("owner").get("login").toString(), node.get("name").toString(), node.get("topics").toString()))
                .collect(Collectors.toList()));

        return listOfRepos.thenApply(repo -> ok(repo.get(0).getAuthorName() + repo.get(0).getRepoName() + repo.get(0).getTopics()));
    }

    private String formatKeywordString(String keywords){
        String[] keyword = keywords.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < keyword.length; i++){
            sb.append(keyword[i]).append("+");
        }
        return sb.toString();
    }







}
