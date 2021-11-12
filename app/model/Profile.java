package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
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
    private int id;
    private String location;
    private String email;
    private String company;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    @Override
    public String toString() {
        return "Profile{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", html_url='" + html_url + '\'' +
                ", id=" + id +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}

