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

    private ArrayList<Repos> repos;

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

    public Profile(String url) {
        String name = url.replaceAll("\"", "");
        String tempUrl = "https://api.github.com/users/" + name.replaceAll(" ", "+");
        String[] commands = new String[]{
                "curl", "-H", "Accept: application/vnd.github.v3+json", tempUrl};
        try {
            Process process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            String response = "";
            while ((line = reader.readLine()) != null) {
                response = response + line;
            }
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response);
            this.login = jsonNode.path("login").asText();
            this.id = jsonNode.path("id").asInt();
            this.name = jsonNode.path("name").asText();
            this.html_url = jsonNode.path("html_url").asText();
            this.followers = jsonNode.path("followers").asInt();
            this.following = jsonNode.path("following").asInt();
            this.location = jsonNode.path("location").asText();
            this.email = jsonNode.path("email").asText();
            this.company = jsonNode.path("company").asText();

        } catch (IOException e) {
            System.out.println("Json Error!");
            e.printStackTrace();
        }
    }

}

