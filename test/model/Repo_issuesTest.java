package model;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class Repo_issuesTest {

    @Test
    void ExceptionTest() {
        Repo_issues issues = new Repo_issues("aaa","aaa","aaa","aaa");
        assertNull(issues.getIssue_createdDate());
    }

    @Test
    void getIssue_description() {
        Repo_issues issues = new Repo_issues();
        issues.setIssue_description("123");
        String actual = issues.getIssue_description();
        assertEquals("123", actual);
    }


    @Test
    void getIssue_name() {
        Repo_issues issues = new Repo_issues();
        issues.setIssue_name("123");
        String actual = issues.getIssue_name();
        assertEquals("123", actual);
    }


    @Test
    void getIssue_title() {
        Repo_issues issues = new Repo_issues();
        issues.setIssue_title("123");
        String actual = issues.getIssue_title();
        assertEquals("123", actual);
    }


    @Test
    void getIssue_createdDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");
        Repo_issues issues = new Repo_issues();
        issues.setIssue_createdDate(sdf.parse("\"2011-05-04T05:44:07Z\""));
        String actual = issues.getIssue_createdDate().toString();
        assertEquals("Wed May 04 05:44:07 EDT 2011", actual);
    }

}