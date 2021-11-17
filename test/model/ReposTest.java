package model;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReposTest {

    @Test
    void exceptionTest() {

        Repos excp = new Repos("aaa", "aaa", "aaa", "aaa", "aaa","aaa","19999","19999","19999","aaa");
        assertNull(excp.getCreatedDate());


    }

    @Test
    void getID() {
        Repos repos = new Repos();
        repos.setID("1");
        String actual = repos.getID();
        assertEquals("1", actual);
    }

    @Test
    void getAuthorName() {
        Repos repos = new Repos();
        repos.setAuthorName("1");
        String actual = repos.getAuthorName();
        assertEquals("1", actual);
    }

    @Test
    void getRepoName() {
        Repos repos = new Repos();
        repos.setRepoName("1");
        String actual = repos.getRepoName();
        assertEquals("1", actual);
    }

    @Test
    void getTopics() {
        Repos repos = new Repos();
        repos.setTopics("1");
        String actual = repos.getTopics();
        assertEquals("1", actual);
    }

    @Test
    void getDescription() {
        Repos repos = new Repos();
        repos.setDescription("1");
        String actual = repos.getDescription();
        assertEquals("1", actual);
    }

    @Test
    void getDefault_branch() {
        Repos repos = new Repos();
        repos.setDefault_branch("1");
        String actual = repos.getDefault_branch();
        assertEquals("1", actual);
    }

    @Test
    void getCreatedDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");
        Repos repos = new Repos();
        repos.setCreatedDate(sdf.parse("\"2011-05-04T05:44:07Z\""));
        String actual = repos.getCreatedDate().toString();
        assertEquals("Wed May 04 05:44:07 EDT 2011", actual);
    }

    @Test
    void getUpdateDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");
        Repos repos = new Repos();
        repos.setUpdateDate(sdf.parse("\"2011-05-04T05:44:07Z\""));
        String actual = repos.getUpdateDate().toString();
        assertEquals("Wed May 04 05:44:07 EDT 2011", actual);
    }

    @Test
    void getPushedDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");
        Repos repos = new Repos();
        repos.setPushedDate(sdf.parse("\"2011-05-04T05:44:07Z\""));
        String actual = repos.getPushedDate().toString();
        assertEquals("Wed May 04 05:44:07 EDT 2011", actual);
    }

    @Test
    void getVisibility() {
        Repos repos = new Repos();
        repos.setVisibility("1");
        String actual = repos.getVisibility();
        assertEquals("1", actual);
    }
}