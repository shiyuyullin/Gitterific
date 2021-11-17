package model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static play.mvc.Results.ok;

/***
 * @author Yun Ni
 * This class handle the induvidual part one, which is to fetch the users detail
 * from Github API and show the user's public info and repos
 */
public class ProcessProfile {

    static List<Profile_Repo> temp = new ArrayList<>();

    /***
     *
     * This method is used to use the para username to fetch JSON files from Github API and convert them
     * to readable format stored in Profile and Profile_Repo class.
     * @param url
     * @return CompletionStage<Result>
     */
    public static CompletionStage<Result> processUsers(String url) {

        String name = url.replaceAll("\"", "").replaceAll(" ", "+");
        String tempUrl = "https://api.github.com/users/" + name;
        CompletionStage<JsonNode> jn = CompletableFuture.supplyAsync(() -> generateJN(tempUrl));

        CompletionStage<List<Profile>> UserProfileList = jn.thenApply(node -> StreamSupport.stream(node.spliterator(), false).
                map(nodes -> new Profile(
                        node.path("login").asText(),
                        node.path("name").asText(),
                        node.path("followers").asInt(),
                        node.path("following").asInt(),
                        node.path("html_url").asText(),
                        node.path("id").asInt(),
                        node.path("location").toString(),
                        node.path("email").toString(),
                        node.path("company").toString()
                )).collect(Collectors.toList()));

        String repoUrl = "https://api.github.com/users/" + name + "/repos";
        CompletionStage<JsonNode> jn2 = CompletableFuture.supplyAsync(() -> generateJN(repoUrl));

        CompletionStage<List<Profile_Repo>> repoList = jn2.thenApply(node -> StreamSupport.stream(node.spliterator(), false).
                map(nodes -> new Profile_Repo(
                        nodes.path("name").asText(),
                        nodes.path("private").asBoolean(),
                        nodes.path("html_url").toString(),
                        nodes.path("created_at").toString(),
                        nodes.path("updated_at").toString(),
                        nodes.path("pushed_at").toString()
                )).collect(Collectors.toList()));


        return repoList.thenApply(profile_repos -> temp = profile_repos)
                .thenCombine(UserProfileList, (profile_repos, users)
                        -> ok(views.html.users.render(users.get(0), profile_repos)));
    }

    /***
     * credit to Rui Wang
     * this method is used to generate JsonNode from the giving url
     * @param url
     * @return JsonNode
     */
    public static JsonNode generateJN(String url){

        JsonNode jasonNode = null;
        String[] commands = new String[]{
                "curl", "-H", "Accept: application/vnd.github.v3+json" ,"Authorization: token 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", url} ;
        try {
            Process process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            String response = "";
            while ((line = reader.readLine()) != null) {
                response = response + line;
            }

            ObjectMapper mapper = new ObjectMapper();
            jasonNode = mapper.readTree(response);
        }catch (IOException e) {
            System.out.println("Json Error!");
        }

        return jasonNode;

    }
}
