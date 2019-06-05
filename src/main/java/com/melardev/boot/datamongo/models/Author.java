package com.melardev.boot.datamongo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "authors")
public class Author {
    @Id
    private String id;

    private String username;
    private List<Article> articles;

    public Author() {
    }

    public Author(String username, List<Article> articles) {
        this.username = username;
        this.articles = articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
