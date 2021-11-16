package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @author Yun Ni
 * This class is used to handle the user's repo info in the user profile page
 * it can show at most 30 repos
 */
public class Profile_Repo {
    private String name;
    private Boolean isPrivate;
    private String html_url;
    private Date created_at;
    private Date updated_at;
    private Date pushed_at;
    private static SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");

    /***
     * the constructor
     * @param name
     * @param isPrivate
     * @param html_url
     * @param created_at
     * @param updated_at
     * @param pushed_at
     */
    public Profile_Repo(String name, Boolean isPrivate, String html_url, String  created_at, String updated_at, String pushed_at) {
        this.name = name;
        this.isPrivate = isPrivate;
        this.html_url = html_url;
        try{
            this.created_at = sdf.parse(created_at);
            this.updated_at = sdf.parse(updated_at);
            this.pushed_at = sdf.parse(pushed_at);
        } catch (ParseException e) {
            System.out.println("Error occurred when parsing date!");
            e.printStackTrace();
        }
    }


    /***
     *
     * @return the repo name
     */
    public String getName() {
        return name;
    }

    /***
     * set the repo name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * get the repo's info
     * @return
     */
    public Boolean getPrivate() {
        return isPrivate;
    }

    /***
     * set the repo info
     * @param aPrivate
     */
    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    /***
     *
     * @return html link
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

    /***
     *
     * @return repo create date
     */
    public Date getCreated_at() {
        return created_at;
    }

    /***
     * set repo  create date
     * @param created_at
     */
    public void setCreated_at(String created_at) {
        try{
            this.created_at = sdf.parse(created_at);
        } catch (ParseException e) {
            System.out.println("Error occurred when parsing date.");
        }

    }

    /***
     *
     * @return the update date
     */
    public Date getUpdated_at() {
        return updated_at;
    }

    /***
     * set the update date
     * @param updated_at
     */
    public void setUpdated_at(String updated_at) {
        try{
            this.created_at = sdf.parse(updated_at);
        } catch (ParseException e) {
            System.out.println("Error occurred when parsing date.");
        }
    }

    /***
     *
     * @return the repo's push date
     */
    public Date getPushed_at() {
        return pushed_at;
    }

    /***
     * get the push info
     * @param pushed_at
     */
    public void setPushed_at(String pushed_at) {
        try{
            this.created_at = sdf.parse(pushed_at);
        } catch (ParseException e) {
            System.out.println("Error occurred when parsing date.");
        }
    }
}
