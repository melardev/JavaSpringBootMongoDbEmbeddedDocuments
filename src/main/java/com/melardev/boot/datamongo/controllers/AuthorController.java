package com.melardev.boot.datamongo.controllers;

import com.melardev.boot.datamongo.models.Article;
import com.melardev.boot.datamongo.models.Author;
import com.melardev.boot.datamongo.repositories.AuthorMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorMongoRepository authorMongoRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> index() {
        Iterable<Author> articlesIterable = authorMongoRepository.findAll();
        List<Author> authorsList = new ArrayList<>();
        articlesIterable.forEach(a -> authorsList.add(a));
        return authorsList;
    }

    @GetMapping(value = "/username/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getByUsername(@PathVariable("value") String username) {
        Iterable<Author> articlesIterable = authorMongoRepository.findByUsernameContainingIgnoreCase(username);
        List<Author> authorsList = new ArrayList<>();
        articlesIterable.forEach(a -> authorsList.add(a));
        return authorsList;
    }

    @GetMapping(value = "/title/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getByTitle(@PathVariable("value") String title) {
        Iterable<Author> articlesIterable = authorMongoRepository.findByArticles_titleContainingIgnoreCase(title);
        List<Author> authorsList = new ArrayList<>();
        articlesIterable.forEach(a -> authorsList.add(a));
        return authorsList;
    }

}
