package model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static play.mvc.Results.ok;

/**
 * This model will handle the individual part 2, which is to fetch the repository details
 * and 20 lastest issues.
 * @author Rui Wang
 */
public class ProcessRepo {
    static List<Repo_issues> temp = new ArrayList<>();

    /**
     * These methods aim to use the author name and repository name to fetch JSON files by Github API and convert them
     * to readable format stored in Repo and Repo_issue class.
     * @param author Author Name
     * @param repo Repository Name
     * @return CompletionStage<Result>
     */
    public static CompletionStage<Result> process(String author, String repo) {


        String name = author.replaceAll(" ", "+") + "/" + repo.replaceAll(" ", "+");
        String tempUrl = "https://api.github.com/repos/" + name;
        CompletionStage<JsonNode> jn = CompletableFuture.supplyAsync(() -> generateJN(tempUrl));

        CompletionStage<List<Repos>> ReposList = jn.thenApply(node -> StreamSupport.stream(node.spliterator(), false).
                map(nodes -> new Repos(
                        node.path("id").asText(),
                        node.path("owner").path("login").asText(),
                        node.path("name").asText(),
                        node.path("topics").toString(),
                        node.path("description").asText(),
                        node.path("default_branch").asText(),
                        node.path("created_at").toString(),
                        node.path("updated_at").toString(),
                        node.path("pushed_at").toString(),
                        node.path("visibility").asText()
                )).collect(Collectors.toList()));

        String issueUrl = "https://api.github.com/repos/" + name + "/issues?per_page=20";
        CompletionStage<JsonNode> jn2 = CompletableFuture.supplyAsync(() -> generateJN(issueUrl));
        CompletionStage<List<Repo_issues>> IssueList = jn2.thenApply(node -> StreamSupport.stream(node.spliterator(), false).
                map(nodes -> new Repo_issues(
                        nodes.path("body").asText(),
                        nodes.path("user").path("login").asText(),
                        nodes.path("title").asText(),
                        nodes.path("created_at").toString()
                )).collect(Collectors.toList()));

        return IssueList.thenApply(repo_issues -> temp = repo_issues).thenCombine(ReposList, (repo_issues, repos) -> ok(views.html.repos.render(repos.get(0), repo_issues)));


    }


    /**
     * Generate JsonNode from the giving url
     * @param url
     * @return JsonNode
     */
    public static JsonNode generateJN(String url) {

        JsonNode jn = null;
        String[] commands = new String[]{
                "curl", "-H", "Accept: application/vnd.github.v3+json", url};
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
            jn = mapper.readTree(response);
        } catch (IOException e) {
            System.out.println("Json Error!");
        }

        return jn;

    }
}
