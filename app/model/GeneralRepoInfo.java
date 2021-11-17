package model;

import java.util.*;
import java.text.*;

/**
 * This class will be used to store the information for matched repository (results from search)
 * Generally, it should contain the username of the author, the name of the repository, and topics (if available),
 * and date of creation.
 *
 * This class is also caching(storing) what a user searched (search keywords) and corresponding results (repos been retrieved)
 */
public class GeneralRepoInfo {

    private static HashMap<String, List<String>> SearchKeywords = new HashMap<>();
    private static HashMap<String, List<List<GeneralRepoInfo>>> RepoList = new HashMap<>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");

    private String authorName;
    private String repoName;
    private String topics;
    private Date createdDate;

    /**
     * Default constructor
     */
    public GeneralRepoInfo() {
        authorName = "";
        repoName = "";
        topics = "";
        createdDate = null;
    }

    /**
     * Parametrized constructor
     * @param authorName
     * @param repoName
     * @param topics
     * @param createdDate
     */
    public GeneralRepoInfo(String authorName, String repoName, String topics, String createdDate) {
        this.authorName = authorName;
        this.repoName = repoName;
        this.topics = topics;
        try{
            this.createdDate = sdf.parse(createdDate);
        }
        catch (ParseException e){
            System.out.println("Error occurred when parsing date.");
        }

    }

    /**
     * This method will search in a HashMap for a given key (username) by using the get() method
     * that is provided by the HashMap class
     * @param username
     * @return List<String>
     */
    public static List<String> getSearchKeywords(String username){
        return SearchKeywords.get(username);
    }

    /**
     * This method will search in a HashMap for a given key (username) by using the get() method that is provided
     * by the HashMap class
     * @param username
     * @return A list of lists of GeneralRepoInfo, which means a list contains List<GeneralRepoInfo>
     */
    public static List<List<GeneralRepoInfo>> getRepoList(String username){
        return RepoList.get(username);
    }

    /**
     * This method will add to a HashMap<String, List<String>>. If the key (username) does not exist in the HashMap, this method will create
     * a key value pair using the given username as key, create a new List<String> and add the given keywords into it, then put them
     * into the HashMap. If the key already exists into HashMap, retrieve its corresponding value and add the given keywords into it.
     * @param username
     * @param keywords
     */
    public static void addSearchKeywords(String username, String keywords){
        if(getSearchKeywords(username) == null){
            List<String> keywordList = new ArrayList<>();
            keywordList.add(keywords);
            SearchKeywords.put(username, keywordList);
        }
        else{
            getSearchKeywords(username).add(keywords);
        }
    }

    /**
     * This method will add to a HashMap<String, List<List<GeneralRepoInfo>>. If the key (username) does not exist in the HashMap, this method will create
     * a key value pair using the given username as key, create a new List<List<GeneralRepoInfo>> and add the given repoList into it, then put them
     * into the HashMap. If the key already exists into HashMap, retrieve its corresponding value and add the given repoList into it.
     * @param username
     * @param repoList
     */
    public static void addRepoList(String username, List<GeneralRepoInfo> repoList){
        if(getRepoList(username) == null){
            List<List<GeneralRepoInfo>> listOfRepoList = new ArrayList<>();
            listOfRepoList.add(repoList);
            RepoList.put(username, listOfRepoList);
        }
        else{
            getRepoList(username).add(repoList);
        }
    }

    /**
     * Setter
     * @param authorName
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * Setter
     * @param repoName
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    /**
     * Setter
     * @param topics
     */
    public void setTopics(String topics) {
        this.topics = topics;
    }

    /**
     * This setter is taking a string which might be anything, try to parse it into a date if the string
     * matches the exact format: "yyyy-MM-ddTHH:mm:ssZ" and set the parsed value to this.createdDate variable
     * @param createdDate
     */
    public void setCreatedDate(String createdDate) {
        try{
            this.createdDate = sdf.parse(createdDate);
        }
        catch (ParseException e){
            System.out.println("Error occurred when parsing date.");
        }
    }

    /**
     * Getter
     * @return author of a repository
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Getter
     * @return name of a repository
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * Getter
     * @return topics of a repository
     */
    public String getTopics() {
        return topics;
    }

    /**
     * Getter
     * @return date when a repository is created (as String)
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * toString method
     * @return formatted output
     */
    public String toString(){
        return this.getAuthorName() + " " + this.getRepoName() + " " + this.getTopics() + " " + this.getCreatedDate();
    }
}