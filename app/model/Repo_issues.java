package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rui Wang
 * This class is used to store 20 latest issues for a repository.
 */
public class Repo_issues {
    private String issue_description;
    private String issue_name;
    private String issue_title;
    private Date issue_createdDate;
    private static SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");


    public Repo_issues(String issue_description, String issue_name, String issue_title, String issue_createdDate) {
        this.issue_description = issue_description;
        this.issue_name = issue_name;
        this.issue_title = issue_title;
        try {
            this.issue_createdDate =  sdf.parse(issue_createdDate);
        } catch (ParseException e) {
            System.out.println("Parse Error!");
            e.printStackTrace();
        }

    }

    public Repo_issues() {

    }

    public String getIssue_description() {
        return issue_description;
    }

    public void setIssue_description(String issue_description) {
        this.issue_description = issue_description;
    }

    public String getIssue_name() {
        return issue_name;
    }

    public void setIssue_name(String issue_name) {
        this.issue_name = issue_name;
    }

    public String getIssue_title() {
        return issue_title;
    }

    public void setIssue_title(String issue_title) {
        this.issue_title = issue_title;
    }

    public Date getIssue_createdDate() {
        return issue_createdDate;
    }

    public void setIssue_createdDate(Date issue_createdDate) {
        this.issue_createdDate = issue_createdDate;
    }
}

