package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Profile_Repo {
    private String name;
    private String full_name;
    private Boolean isPrivate;
    private String html_url;
    private Date created_at;
    private Date updated_at;
    private Date pushed_at;
    private static SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"");



    public Profile_Repo(String name, String full_name, Boolean isPrivate, String html_url, String  created_at, String updated_at, String pushed_at) {
        this.name = name;
        this.full_name = full_name;
        this.isPrivate = isPrivate;
        this.html_url = html_url;
        try{
            this.created_at = sdf.parse(String.valueOf(created_at));
            this.updated_at = sdf.parse(String.valueOf(updated_at));
            this.pushed_at = sdf.parse(String.valueOf(pushed_at));
        } catch (ParseException e) {
            System.out.println("Parse Error!");
            e.printStackTrace();
        }


    }

//    public Profile_Repo(String name, String full_name, boolean isPrivate, String html_url, String created_at, String updated_at, String pushed_at) {
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(Date pushed_at) {
        this.pushed_at = pushed_at;
    }
}
