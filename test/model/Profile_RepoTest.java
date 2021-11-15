package model;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/***
 * test for the {@link Profile_Repo} class
 * @author Yun Ni
 */
class Profile_RepoTest {


    @Test
    void getName() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z");
        profile_repo.setName("nina");
        assertEquals("nina", profile_repo.getName());
    }

    @Test
    void setName() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z");
        profile_repo.setName("nina");
        assertEquals("nina", profile_repo.getName());
    }

    @Test
    void getPrivate() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z");
        profile_repo.setPrivate(false);
        assertEquals(false, profile_repo.getPrivate());
    }

    @Test
    void setPrivate() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z");
        profile_repo.setPrivate(false);
        assertEquals(false, profile_repo.getPrivate());
    }

    @Test
    void getHtml_url() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z");
        profile_repo.setHtml_url("nana");
        assertEquals("nana", profile_repo.getHtml_url());
    }

    @Test
    void setHtml_url() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z", "2020-01-25T04:16:53Z");
        profile_repo.setHtml_url("nana");
        assertEquals("nana", profile_repo.getHtml_url());
    }

    @Test
    void getCreated_at() {

    }

    @Test
    void setCreated_at() {
    }

    @Test
    void getUpdated_at() {
    }

    @Test
    void setUpdated_at() {
    }

    @Test
    void getPushed_at() {
    }

    @Test
    void setPushed_at() {
    }
}