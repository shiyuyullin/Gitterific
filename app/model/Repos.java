package model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used to all available details for a repository
 * @author Rui Wang
 */

public class Repos {
    private static SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");


    public Repos() {

    }
//    private String repoUrl;
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

    public Repos(String ID, String authorName, String repoName, String topics, String description, String default_branch, String createdDate, String updateDate, String pushedDate, String visibility) {
        this.ID = ID;
        this.authorName = authorName;
        this.repoName = repoName;
        this.topics = topics;
        this.description = description;
        this.default_branch = default_branch;
        this.visibility = visibility;
            try {
                this.createdDate = sdf.parse(createdDate);
                this.updateDate = sdf.parse(updateDate);
                this.pushedDate = sdf.parse(pushedDate);
            } catch (ParseException e) {
                System.out.println("Parse Error!");
            }
    }



}
