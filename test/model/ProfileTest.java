package model;

import org.hibernate.validator.internal.properties.Getter;
import org.junit.Test;
import static org.junit.Assert.*;

/***
 * test for the Profile class
 * @author Yun Ni
 */
public class ProfileTest {
    /***
     * Getter test for ID
     */
    @Test
    public void getId() {
        Profile profile = new Profile();
        profile.setId(1);
        assertEquals(1, profile.getId());
    }

    /**
     * Setter test for ID
     */
    @Test
    public void setId() {
        Profile profile = new Profile();
        profile.setId(1);
        assertEquals(1, profile.getId());
    }

    /***
     * Getter test for Location
     */
    @Test
    public void getLocation() {
        Profile profile = new Profile();
        profile.setLocation("Montreal");
        assertEquals("Montreal", profile.getLocation());
    }

    /**
     * Setter test for Location
     */
    @Test
    public void setLocation() {
        Profile profile = new Profile();
        profile.setLocation("Montreal");
        assertEquals("Montreal", profile.getLocation());
    }

    /***
     * Getter test for Email
     */
    @Test
    public void getEmail() {
        Profile profile = new Profile();
        profile.setEmail("nina@gmai.com");
        assertEquals("nina@gmai.com", profile.getEmail());
    }

    /**
     * Setter test for Email
     */
    @Test
    public void setEmail() {
        Profile profile = new Profile();
        profile.setEmail("nina@gmai.com");
        assertEquals("nina@gmai.com", profile.getEmail());
    }

    /***
     * Getter test for Company
     */
    @Test
    public void getCompany() {
        Profile profile = new Profile();
        profile.setCompany("Ant");
        assertEquals("Ant", profile.getCompany());
    }

    /**
     * Setter test for Company
     */
    @Test
    public void setCompany() {
        Profile profile = new Profile();
        profile.setCompany("Ant");
        assertEquals("Ant", profile.getCompany());
    }

    /***
     * Getter test for Login
     */
    @Test
    public void getLogin() {
        Profile profile = new Profile();
        profile.setLogin("Nia");
        assertEquals("Nia", profile.getLogin());
    }

    /**
     * Setter test for Login
     */
    @Test
    public void setLogin() {
        Profile profile = new Profile();
        profile.setLogin("Nia");
        assertEquals("Nia", profile.getLogin());
    }

    /***
     * Getter test for Name
     */
    @Test
    public void getName() {
        Profile profile = new Profile();
        profile.setName("ning");
        assertEquals("ning", profile.getName());
    }

    /**
     * Setter test for Name
     */
    @Test
    public void setName() {
        Profile profile = new Profile();
        profile.setName("ning");
        assertEquals("ning", profile.getName());
    }

    /***
     * Getter test for Followers
     */
    @Test
    public void getFollowers() {
        Profile profile = new Profile();
        profile.setFollowers(1);
        assertNotEquals(0, profile.getFollowers());
    }

    /**
     * Setter test for Followers
     */
    @Test
    public void setFollowers() {
        Profile profile = new Profile();
        profile.setFollowers(1);
        assertEquals(1, profile.getFollowers());
    }

    /***
     * Getter test for Following
     */
    @Test
    public void getFollowing() {
        Profile profile = new Profile();
        profile.setFollowing(11);
        assertEquals(11, profile.getFollowing());
    }

    /**
     * Setter test for Following
     */
    @Test
    public void setFollowing() {
        Profile profile = new Profile();
        profile.setFollowing(11);
        assertEquals(11, profile.getFollowing());
    }

    /***
     * Getter test for Html_url
     */
    @Test
    public void getHtml_url() {
        Profile profile = new Profile();
        profile.setHtml_url("aaaa");
        assertEquals("aaaa", profile.getHtml_url());
    }

    /**
     * Setter test for Html_url
     */
    @Test
    public void setHtml_url() {
        Profile profile = new Profile();
        profile.setHtml_url("aaaa");
        assertEquals("aaaa", profile.getHtml_url());
    }

    @Test
    public void ConstructorTests(){
        Profile profile1 = new Profile();
        Profile profile2 = new Profile("aa", "aaa", 1, 1, "aaa", 2, "Montreal", "sa", "aa");
        assertNull(profile1.getLogin());
        assertEquals("aa", profile2.getLogin());
        assertNull(profile1.getName());
        assertEquals("aaa", profile2.getName());
        assertEquals(0,profile1.getFollowers());
        assertEquals(1,profile2.getFollowers());
        assertEquals(0,profile1.getFollowing());
        assertEquals(1,profile2.getFollowing());
        assertNull(profile1.getHtml_url());
        assertEquals("aaa",profile2.getHtml_url());
        assertEquals(0, profile1.getId());
        assertEquals(2, profile2.getId());
        assertNull(profile1.getLocation());
        assertEquals("Montreal",profile2.getLocation());
        assertNull(profile1.getEmail());
        assertEquals("sa",profile2.getEmail());
        assertNull(profile1.getCompany());
        assertEquals("aa",profile2.getCompany());

    }
}