package model;

/**
 * @author Yun Ni
 * This class is used to get the details of user
 * It will return the public inforamtion of a particular user
 */

public class Profile {
    private String login; //user login name
    private String name; //User Define name
    private int followers;
    private int following;
    private String html_url;
    private int id;
    private String location;
    private String email;
    private String company;

    public Profile() {
    }

    /***
     * the Constructor of the user profile
     * @param login
     * @param name
     * @param followers
     * @param following
     * @param html_url
     * @param id
     * @param location
     * @param email
     * @param company
     */
    public Profile(String login, String name, int followers, int following, String html_url, int id, String location, String email, String company) {
        this.login = login;
        this.name = name;
        this.followers = followers;
        this.following = following;
        this.html_url = html_url;
        this.id = id;
        this.location = location;
        this.email = email;
        this.company = company;
    }

    /***
     *
     * @return the github id of a user
     */
    public int getId() {
        return id;
    }

    /***
     *
     * @param id
     * set the id of a user
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /***
     * set the location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /***
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /***
     * set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /***
     *
     * @return the company info if the user has
     */
    public String getCompany() {
        return company;
    }

    /***
     * set company info
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /***
     *
     * @return the login id
     */
    public String getLogin() {
        return login;
    }

    /***
     * set login id
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /***
     * get the name
     * @return
     */
    public String getName() {
        return name;
    }

    /***
     * set the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * get the follower
     * @return
     */
    public int getFollowers() {
        return followers;
    }

    /***
     * set the follower
     * @param followers
     */
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /***
     * get the following
     * @return
     */
    public int getFollowing() {
        return following;
    }

    /***
     * set the following
     * @param following
     */
    public void setFollowing(int following) {
        this.following = following;
    }

    /***
     * get the html info
     * @return
     */
    public String getHtml_url() {
        return html_url;
    }

    /***
     * set the html info
     * @param html_url
     */
    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }


}

