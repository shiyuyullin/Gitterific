package model;

import java.util.Arrays;
import java.util.List;

public class Repository {

    private String authorName;
    private String repoName;
    private String topics;

    public Repository(){
        authorName = "";
        repoName = "";
        topics = "";
    }

    public Repository(String authorName, String repoName, String topics){
        this.authorName = authorName;
        this.repoName = repoName;
        this.topics = topics;
    }

    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }

    public void setRepoName(String repoName){
        this.repoName = repoName;
    }

    public void setTopics(String topics){
        this.topics = topics;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getTopics() {
        return topics;
    }
}
