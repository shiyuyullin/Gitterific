package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * This class is used to all available details for a repository
 */

public class Repos {
    private static SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");

    public Repos() {
    }

    private String ID;
    private String authorName;
    private String repoName;
    private String topics;
    private String description;
    private String default_branch;
    private Date createdDate;
    private Date updateDate;
    private Date pushedDate;
    private String visibility;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getPushedDate() {
        return pushedDate;
    }

    public void setPushedDate(Date pushedDate) {
        this.pushedDate = pushedDate;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }




    public Repos(String url) {
        String name = url.replaceAll("\"","");
        String tempUrl = "https://api.github.com/repos/" + name.replaceAll(" ","+");
        String[] commands = new String[]{
                "curl", "-H", "Accept: application/vnd.github.v3+json", tempUrl} ;
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
            JsonNode jn = mapper.readTree(response);
            this.ID = jn.path("id").asText();
            this.authorName = jn.path("owner").path("login").asText();
            this.default_branch = jn.path("default_branch").asText();
            this.description = jn.path("description").asText();
            this.repoName = jn.path("name").asText();
            this.topics = jn.path("topics").toString();
            this.visibility = jn.path("visibility").asText();
            this.createdDate = sdf.parse(jn.path("created_at").toString());
            this.updateDate = sdf.parse(jn.path("updated_at").toString());
            this.pushedDate = sdf.parse(jn.path("pushed_at").toString());


        } catch (IOException e) {
            System.out.println("Json Error!");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Parse Error!");
            e.printStackTrace();
        }
    }




}
