package model;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import play.libs.ws.*;

import java.util.*;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import static play.mvc.Results.ok;

/**
 * @author Shiyu Lin
 * This model will handle the individual part 3, which is to fetch the available issues
 * and counting all unique words in descending order.
 */
public class Issues implements WSBodyReadables, WSBodyWritables{

    private final WSClient ws;

    @Inject
    public Issues(WSClient ws){
        this.ws = ws;
    }

    /**
     * Render the view for issue statistics page with a given list of titles
     * @param listOfTitles
     * @return CompletionStage<Result>
     */
    public CompletionStage<Result> renderResult(CompletionStage<List<String>> listOfTitles){

        // The error does not matter, app will run just fine
        CompletionStage<Result> result = listOfTitles.thenApply(titles -> ok(views.html.issue.render(titles, sortWordCount(countUniqueWords(titles)))));
        return result;
    }

    /**
     * @author Shiyu Lin
     * The method will form an http request using WSClient, processing the response
     * (getting the titles).
     * @return CompletionStage<List<String>> future list of titles
     */
    public CompletionStage<List<String>> getIssuesTitles(){

        WSRequest request = ws.url("https://api.github.com/repos/octocat/hello-world/issues")
                .addHeader("Accept", "application/vnd.github.v3+json");

        CompletionStage<WSResponse> response = request.get();

        CompletionStage<JsonNode> nodes = response.thenApply(WSResponse::asJson);

        CompletionStage<List<String>> listOfTitles = nodes
                .thenApply(jsonNode -> StreamSupport.stream(jsonNode.spliterator(), false)
                        .map(node -> node.get("title"))
                        .map(JsonNode::toString)
                        .collect(Collectors.toList()));
        return listOfTitles;
    }

    /**
     * @author Shiyu Lin
     * Processing a list of titles. Replace all special characters by a space, and
     * generate an array for each title using split(" "), merge them together and form a Stream<String>
     * then count each word in that stream, finally collect them into a map.
     * @param listOfTitles
     */
    private Map<String,Long> countUniqueWords(List<String> listOfTitles){
        return listOfTitles.stream()
                .map(title -> title.replaceAll("[^a-zA-Z0-9]", " "))
                .map(title -> title.split(" "))
                .flatMap(Arrays::stream)
                .filter(title -> title.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * @author Shiyu Lin
     * Sorting a hashmap based on the "value" of key:value
     * @return HashMap<String,Long>
     */
    private HashMap<String,Long> sortWordCount(Map<String,Long> wordCount){
        List<Map.Entry<String, Long>> list = new ArrayList<>(wordCount.entrySet());
        list.sort(new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        HashMap<String, Long> result = new LinkedHashMap<>();
        for(Map.Entry<String,Long> entry : list){
            result.put(entry.getKey(),entry.getValue());
        }
        return result;
    }

}
