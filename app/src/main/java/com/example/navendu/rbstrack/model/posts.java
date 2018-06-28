package com.example.navendu.rbstrack.model;

/**
 * Created by navendu on 28/6/18.
 */

public class posts {

    int userId;
    int id;
    String title;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String body;


    public posts()
    {}
    public posts(int i1,int i2,String s1,String s2){

        this.userId=i1;
        this.id=i2;
        this.body=s2;
        this.title=s1;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
