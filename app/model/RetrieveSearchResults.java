package model;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.routes;
import play.mvc.*;
import play.libs.ws.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static play.mvc.Results.*;

/**
 * This class will be used for retrieving search results (repository information) from GitHub by using GitHub API
 * in an asynchronous manner. Actual communication between the app and the GitHub server(Sending http request,etc.) is
 * done through WSClient provided by play framework.
 */
public class RetrieveSearchResults implements WSBodyReadables, WSBodyWritables {

    private final WSClient ws;

    @Inject
    public RetrieveSearchResults(WSClient ws){
        this.ws = ws;
    }

    /**
     * Search for repository using some keywords, and retrieve them as JsonNode
     * @param keywords
     * @return future JsonNode(it will finally be a JsonNode)
     */
    public CompletionStage<JsonNode> getRepoInfoAsJsonNode(String keywords){
        String formattedKeywords = formatKeywordString(keywords);
        return ws.url("https://api.github.com/search/repositories?q=" + formattedKeywords + "&sort=updated")
                .addHeader("Accept","application/vnd.github.v3+json")
                .get()
                .thenApply(WSResponse::asJson);
    }

    /**
     * This method handle user session and caching. This method will take a future JsonNode, chain it with some method calls
     * to retrieve what is needed to create a GeneralRepoInfo object (ex. author name, repo name, etc.) collect all GeneralRepoInfo
     * objects into a list, sort the list based on the createdDate attribute of the objects, then cache the list to a local store(HashMap)
     * , using the username as key. It would also cache the search keywords that is used to get the future JsonNode, using the username as
     * key as well. After all, it renders the index page for the user with the given username.
     * @param keywords
     * @param username
     * @param futureJson
     * @return future Result(it will finally be a Result)
     */
    public CompletionStage<Result> searchForRepo(String keywords, String username, Http.Request request, CompletionStage<JsonNode> futureJson){

        if(keywords == null || username == null || futureJson == null){
            return CompletableFuture.completedStage(ok(views.html.index.render(null,null, request)));
        }
        else if(keywords.length() == 0){
            return CompletableFuture.completedStage(ok(views.html.index.render(GeneralRepoInfo.getRepoList(username), GeneralRepoInfo.getSearchKeywords(username), request)));
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
                    .limit(10)
                    .collect(Collectors.toList()));
            return listOfRepos.thenApply(repo -> {
                GeneralRepoInfo.addRepoList(username, repo);
                GeneralRepoInfo.addSearchKeywords(username, keywords);
                return ok(views.html.index.render(GeneralRepoInfo.getRepoList(username),GeneralRepoInfo.getSearchKeywords(username), request));
            });
        }
    }

    /**
     * Given some keywords, return list of GeneralRepoInfo
     * @param keywords
     * @return
     */
    public CompletionStage<List<GeneralRepoInfo>> getRepoAsAList(String keywords){
        CompletionStage<JsonNode> jsNode = getRepoInfoAsJsonNode(keywords);
        CompletionStage<JsonNode> items = jsNode.thenApply(jsonNode -> jsonNode.get("items"));
        CompletionStage<List<GeneralRepoInfo>> listOfRepos = items.thenApply(nodes -> StreamSupport.stream(nodes.spliterator(), false)
                .map(node -> new GeneralRepoInfo(
                                node.get("owner").get("login").toString(),
                                node.get("name").toString(),
                                node.get("topics").toString(),
                                node.get("created_at").toString()
                        )
                )
                .limit(10)
                .collect(Collectors.toList()));
        return listOfRepos;
    }

    /**
     * Since what we get from the front-end form are words separated by space(ex. java ai DL)
     * it could not be used directly to form a http request. This method will format what we got
     * from the front-end form.(ex. java ai DL -> java+ai+DL | java -> java)
     * @param keywords
     * @return formatted keywords
     */
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

//    /**
//     * This method will take a future List<GeneralRepoInfo>, chain it with another method to sort it
//     * based on the createdDate attribute of the objects inside the list.
//     * @param listOfRepos
//     * @return future list of GeneralRepoInfo
//     */
//    public CompletionStage<List<GeneralRepoInfo>> sortByDate(CompletionStage<List<GeneralRepoInfo>> listOfRepos){
//        if(listOfRepos == null) return CompletableFuture.completedStage(new ArrayList<>());
//        CompletionStage<List<GeneralRepoInfo>> sorted =  listOfRepos.thenApply(repos -> repos.stream()
//                .sorted(Comparator.comparing(GeneralRepoInfo::getCreatedDate).reversed())
//                .collect(Collectors.toList()));
//        return sorted;
//    }

}
