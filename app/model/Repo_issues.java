package model;

import java.util.Date;

public class Repo_issues {
    private String issue_description;
    private String issue_name;
    private String issue_title;
    private Date issue_createdDate;

    public Repo_issues(String issue_description, String issue_name, String issue_title, Date issue_createdDate) {
        this.issue_description = issue_description;
        this.issue_name = issue_name;
        this.issue_title = issue_title;
        this.issue_createdDate = issue_createdDate;
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

