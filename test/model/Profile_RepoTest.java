package model;



import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;


/***
 * test for the Profile_Repo class
 * @author Yun Ni
 */
public class Profile_RepoTest {


    /***
     * Getter test for Name
     */
    @Test
    public void getName() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setName("nina");
        assertEquals("nina", profile_repo.getName());
    }

    /***
     * Setter test for Name
     */
    @Test
    public void setName() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setName("nina");
        assertEquals("nina", profile_repo.getName());
    }

    /***
     * Getter test for Private file
     */
    @Test
    public void getPrivate() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setPrivate(false);
        assertEquals(false, profile_repo.getPrivate());
    }

    /***
     * Setter test for Private file
     */
    @Test
    public void setPrivate() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setPrivate(false);
        assertEquals(false, profile_repo.getPrivate());
    }

    /***
     * Getter test for html_url
     */
    @Test
    public void getHtml_url() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setHtml_url("nana");
        assertEquals("nana", profile_repo.getHtml_url());
    }

    /***
     * Setter test for html_url
     */
    @Test
    public void setHtml_url() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setHtml_url("nana");
        assertEquals("nana", profile_repo.getHtml_url());
    }

    /***
     * Getter test for create date
     */
    @Test
    public void getCreated_at() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setCreated_at("\"2018-10-29T17:15:57Z\"");
        assertEquals("Mon Oct 29 17:15:57 EDT 2018",  profile_repo.getCreated_at().toString());
    }

    /***
     * Setter test for create date
     */
    @Test
    public void setCreated_at() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setCreated_at("\"2018-10-29T17:15:57Z\"");
        assertEquals("Mon Oct 29 17:15:57 EDT 2018",  profile_repo.getCreated_at().toString());
    }

    /***
     * Getter test for update date
     */
    @Test
    public void getUpdated_at() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setUpdated_at("\"2018-10-29T17:15:57Z\"");
        assertEquals("Wed Aug 29 17:15:57 EDT 2018",  profile_repo.getUpdated_at().toString());
    }


    /***
     * Setter test for update date
     */
    @Test
    public void setUpdated_at() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setUpdated_at("\"2018-10-29T17:15:57Z\"");
        assertEquals("Wed Aug 29 17:15:57 EDT 2018",  profile_repo.getUpdated_at().toString());
    }

    /***
     * Getter test for push date
     */
    @Test
    public void getPushed_at() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setPushed_at("\"2018-10-29T17:15:57Z\"");
        assertEquals("Wed Aug 29 17:15:57 EDT 2018",  profile_repo.getPushed_at().toString());
    }

    /***
     * Setter test for push date
     */
    @Test
    public void setPushed_at() {
        Profile_Repo profile_repo = new Profile_Repo("aa", true, "aaa", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"", "\"2018-08-29T17:15:57Z\"");
        profile_repo.setPushed_at("\"2018-10-29T17:15:57Z\"");
        assertEquals("Wed Aug 29 17:15:57 EDT 2018",  profile_repo.getPushed_at().toString());
    }

    @Test
    public void ExceptionCaseTest(){
        Profile_Repo badTest = new Profile_Repo("aa", true, "aaa", "123", "123", "123");
        assertNull(badTest.getCreated_at());
        assertNull(badTest.getPushed_at());
        assertNull(badTest.getUpdated_at());


        Profile_Repo badTest2 = new Profile_Repo("aa", true, "aaa", "222", "222", "222");
        badTest2.setCreated_at("123");
        assertNull(badTest2.getCreated_at());
        badTest2.setUpdated_at("123");
        assertNull(badTest2.getUpdated_at());
        badTest2.setPushed_at("123");
        assertNull(badTest2.getPushed_at());
    }

}