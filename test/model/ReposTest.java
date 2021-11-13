package model;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReposTest {

    @Test
    void RepoTest() {
        Repos repos = new Repos();
        Date d = new Date();
        d.setYear(0);
        d.setMonth(0);
        d.setTime(0);
        d.setDate(1);


//        Exception e = assertThrows(ParseException.class,() ->  new Repos("aaa", "aaa", "aaa", "aaa", "aaa","aaa","19999","19999","19999","aaa") );
//        System.out.println(e.getMessage());
        try{
            Repos excep = new Repos("aaa", "aaa", "aaa", "aaa", "aaa","aaa","1999","1999","1999","aaa");
        }catch (Exception e){
            System.out.println("Throws Exception");
//            e.printStackTrace();
        }



        Repos Test = new Repos("aaa", "aaa", "aaa", "aaa", "aaa","aaa","\"2018-01-25T04:16:53Z\"","\"2018-01-25T04:16:53Z\"","\"2018-01-25T04:16:53Z\"","aaa");
        repos.setAuthorName("Author");
        repos.setCreatedDate(d);
        repos.setRepoName("RepoName");
        repos.setDescription("Description");
        repos.setDefault_branch("branch");
        repos.setID("ID");
        repos.setTopics("Topic");
        repos.setVisibility("Visibility");
        repos.setPushedDate(d);
        repos.setUpdateDate(d);

        repos.getAuthorName();
        repos.getCreatedDate();
        repos.getRepoName();
        repos.getDescription();
        repos.getDefault_branch();
        repos.getID();
        repos.getTopics();
        repos.getVisibility();
        repos.getUpdateDate();
        repos.getPushedDate();

        assertEquals("Repos{ID='ID', authorName='Author', repoName='RepoName', topics='Topic', description='Description', default_branch='branch', createdDate=Mon Dec 01 19:00:00 EST 1969, updateDate=Mon Dec 01 19:00:00 EST 1969, pushedDate=Mon Dec 01 19:00:00 EST 1969, visibility='Visibility'}", repos.toString());
    }
}