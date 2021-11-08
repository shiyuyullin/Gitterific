package model;

import java.util.Arrays;
import java.util.List;

/**
 * This classes will be used to store the information for matched repository (results from search)
 * Generally, it should contain the username of the author, the name of the repository, and topics (if available)
 */
public class GeneralRepoInfo {

    private String authorName;
    private String repoName;
    private String topics;

    public GeneralRepoInfo() {
        authorName = "";
        repoName = "";
        topics = "";
    }

    public GeneralRepoInfo(String authorName, String repoName, String topics) {
        this.authorName = authorName;
        this.repoName = repoName;
        this.topics = topics;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public void setTopics(String topics) {
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