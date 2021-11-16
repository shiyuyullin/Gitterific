package model;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class GeneralRepoInfoTest {

    @Test
    void ConstructorTests(){
        GeneralRepoInfo repo1 = new GeneralRepoInfo();
        GeneralRepoInfo repo2 = new GeneralRepoInfo("aaa", "bbb", "topics", "\"2018-08-29T17:15:57Z\"");

        assertEquals("", repo1.getRepoName());
        assertEquals("", repo1.getAuthorName());
        assertEquals("", repo1.getTopics());
        assertNull(repo1.getCreatedDate());

        assertEquals("aaa", repo2.getAuthorName());
        assertEquals("bbb", repo2.getRepoName());
        assertEquals("topics", repo2.getTopics());
        assertEquals("Wed Aug 29 17:15:57 EDT 2018", repo2.getCreatedDate().toString());
    }

    @Test
    void StaticMethodsTest(){
        GeneralRepoInfo.addSearchKeywords("user1", "java");
        GeneralRepoInfo.addSearchKeywords("user1", "python");
        assertEquals("python", GeneralRepoInfo.getSearchKeywords("user1").get(1));
        assertNull(GeneralRepoInfo.getSearchKeywords("user2"));

        List<GeneralRepoInfo> list1 = new ArrayList<>();
        list1.add(new GeneralRepoInfo());
        List<GeneralRepoInfo> list2 = new ArrayList<>();
        GeneralRepoInfo.addRepoList("user1", list1);
        GeneralRepoInfo.addRepoList("user1", list2);
        assertEquals("", GeneralRepoInfo.getRepoList("user1").get(0).get(0).getAuthorName());
        assertNull(GeneralRepoInfo.getRepoList("user2"));
    }

    @Test
    void SetterTest(){

        GeneralRepoInfo repo = new GeneralRepoInfo();
        repo.setAuthorName("aaa");
        assertEquals("aaa", repo.getAuthorName());
        repo.setRepoName("bbb");
        assertEquals("bbb", repo.getRepoName());
        repo.setTopics("topics");
        assertEquals("topics", repo.getTopics());
        repo.setCreatedDate("\"2018-08-29T17:15:57Z\"");
        assertEquals("Wed Aug 29 17:15:57 EDT 2018", repo.getCreatedDate().toString());
    }

    @Test
    void ToStringTest(){
        GeneralRepoInfo repo = new GeneralRepoInfo("aaa", "bbb", "topics", "\"2018-08-29T17:15:57Z\"");
        assertEquals("aaa bbb topics Wed Aug 29 17:15:57 EDT 2018", repo.toString());
    }

    @Test
    void ExceptionCaseTest(){
        GeneralRepoInfo badRepo1 = new GeneralRepoInfo("aaa", "bbb", "topics", "123");
        assertNull(badRepo1.getCreatedDate());

        GeneralRepoInfo badRepo2 = new GeneralRepoInfo();
        badRepo2.setCreatedDate("123");
        assertNull(badRepo2.getCreatedDate());
    }







}
