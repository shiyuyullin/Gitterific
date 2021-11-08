package model;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import play.libs.ws.*;

import java.util.*;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static play.mvc.Results.ok;

/**
 * @author Shiyu Lin
 * This model will handle the individual part 3, which is to fetch the available issues
 * and counting all unique words in descending order.
 */
public class Issues implements WSBodyReadables, WSBodyWritables{

    private final WSClient ws;
    private static HashMap<String, Integer> wordCount = new HashMap<>();

    @Inject
    public Issues(WSClient ws){
        this.ws = ws;
    }

    /**
     * The method will form an http request using WSClient, processing the response
     * (getting the titles, and counting all unique words in descending order).
     * @return CompletionStage<Result> the actual web page
     */
    public CompletionStage<Result> getIssues(){

        WSRequest request = ws.url("https://api.github.com/repos/octocat/hello-world/issues")
                .addHeader("Accept", "application/vnd.github.v3+json");

        CompletionStage<WSResponse> response = request.get();

        CompletionStage<JsonNode> nodes = response.thenApply(WSResponse::asJson);

        CompletionStage<List<String>> listOfTitles = nodes
                .thenApply(jsonNode -> StreamSupport.stream(jsonNode.spliterator(), false)
                        .map(node -> node.get("title"))
                        .map(JsonNode::toString)
                        .collect(Collectors.toList()));

        uniqueDescending(listOfTitles);
        return listOfTitles.thenApply(titles -> ok(views.html.issue.render(titles, sortWordCount())));
    }

    /**
     * Processing a list of titles asynchronously. Replace all special characters by a space, and
     * generate an array for each title using split(" "), merge them together and form a Stream<String>
     * then count each word in that stream.
     * @param listOfTitles
     */
    private void uniqueDescending(CompletionStage<List<String>> listOfTitles){

        CompletionStage<Stream<String>> stringStream = listOfTitles.thenApply(
                titles -> titles.stream()
                        .map(title -> title.replaceAll("[^a-zA-Z0-9]", " "))
                        .map(title -> title.split(" "))
                        .flatMap(Arrays::stream)
        );

        stringStream.thenAccept(streamOfStrings -> streamOfStrings.forEach(this::addToWordCount));
    }

    /**
     * Given a string, use the content of the string as the key, check if it has a corresponding value.
     * If yes, incremental the value by 1, if no, create a new entry with key = content of the string and
     * value = 1
     * @param word
     */
    private void addToWordCount(String word){
        if(word.length() != 0 && wordCount.get(word) != null){
            Integer currentCount = wordCount.get(word);
            wordCount.put(word, currentCount+1);
        }
        else if(word.length() != 0 && wordCount.get(word) == null){
            wordCount.put(word, 1);
        }
    }

    /**
     * Sorting a hashmap based on the "value" of key:value
     * @return HashMap<String,Integer>
     */
    private HashMap<String,Integer> sortWordCount(){
        Set<Map.Entry<String, Integer>> set = wordCount.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
        list.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }));
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < list.size(); i++){
            map.put(list.get(i).getKey(), list.get(i).getValue());
        }
        return map;
    }

}
