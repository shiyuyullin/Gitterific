package model;

import java.util.Arrays;
import java.util.Date;
import java.text.*;
import java.util.List;

/**
 * This classes will be used to store the information for matched repository (results from search)
 * Generally, it should contain the username of the author, the name of the repository, and topics (if available)
 */
public class GeneralRepoInfo {

    private static SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");

    private String authorName;
    private String repoName;
    private String topics;
    private Date createdDate;

    public GeneralRepoInfo() {
        authorName = "";
        repoName = "";
        topics = "";
        createdDate = null;
    }

    public GeneralRepoInfo(String authorName, String repoName, String topics, String createdDate) {
        this.authorName = authorName;
        this.repoName = repoName;
        this.topics = topics;
        try{
            this.createdDate = sdf.parse(createdDate);
        }
        catch (ParseException e){
            System.out.println("Error occurred when parsing date.");
        }

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

    public void setCreatedDate(String createdDate) {
        try{
            System.out.println(createdDate);
            this.createdDate = sdf.parse(createdDate);
        }
        catch (ParseException e){
            System.out.println("Error occurred when parsing date.");
        }
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public String toString(){
        return this.getAuthorName() + " " + this.getRepoName() + " " + this.getTopics();
    }
}