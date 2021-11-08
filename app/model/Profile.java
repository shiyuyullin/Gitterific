package model;

import java.util.ArrayList;

/**
 * This class is used to get the details of user
 */

public class Profile {
    private String login; //user login name
    private String name; //User Define name
    private int followers;
    private int following;
    private String html_url;
    private ArrayList<Repos> repos;

    public Profile() {
    }

    public Profile(String login, String name, int followers, int following, String html_url, ArrayList<Repos> repos) {
        this.login = login;
        this.name = name;
        this.followers = followers;
        this.following = following;
        this.html_url = html_url;
        this.repos = repos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public ArrayList<Repos> getRepos() {
        return repos;
    }

    public void setRepos(ArrayList<Repos> repos) {
        this.repos = repos;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", html_url='" + html_url + '\'' +
                ", repos=" + repos +
                '}';
    }
}

