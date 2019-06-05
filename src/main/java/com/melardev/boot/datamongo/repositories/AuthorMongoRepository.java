package com.melardev.boot.datamongo.repositories;

import com.melardev.boot.datamongo.models.Article;
import com.melardev.boot.datamongo.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorMongoRepository extends MongoRepository<Author, String> {

    //public List<Article> findByTitleContains(String title);

    public List<Author> findByUsernameContainingIgnoreCase(String username);
    public List<Author> findByArticles_titleContainingIgnoreCase(String title);

}
