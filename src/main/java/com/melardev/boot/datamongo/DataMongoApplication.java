package com.melardev.boot.datamongo;

import com.melardev.boot.datamongo.models.Article;
import com.melardev.boot.datamongo.models.Author;
import com.melardev.boot.datamongo.repositories.AuthorMongoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
//@EnableMongoRepositories
public class DataMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataMongoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AuthorMongoRepository authorMongoRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                authorMongoRepository.deleteAll();

                final Article article1 = new Article("Spring Boot - MongoDB + Data + Web"
                        , "MongoDB", df.parse("10/5/2018"));
                final Article article2 = new Article("Spring Boot - MongoDB + Data + Web"
                        , "H2 Console", df.parse("2/3/2016"));
                final Article article3 = new Article("Spring Cloud - Zuul + Eureka + Rest Web", "Load Balancer with Zuul", df.parse("5/1/2018"));
                final Article article4 = new Article("Spring Cloud - Feign"
                        , "Feign Client + Eureka + Rest", df.parse("5/6/2018"));

                Author author1 = new Author("Melardev", Arrays.asList(article1, article2));
                Author author2 = new Author("Momo", Arrays.asList(article3, article4));

                authorMongoRepository.save(author1);
                authorMongoRepository.save(author2);

            }
        };
    }
}
