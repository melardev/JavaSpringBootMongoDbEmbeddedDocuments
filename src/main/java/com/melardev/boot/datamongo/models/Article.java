package com.melardev.boot.datamongo.models;

import java.util.Date;


public class Article {


    private String title;
    private String body;

    private Date createdAt;

    public Article() {
    }

    public Article(String title, String body, Date createdAt) {

        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
