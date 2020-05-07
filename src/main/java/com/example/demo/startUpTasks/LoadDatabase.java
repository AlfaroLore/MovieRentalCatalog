package com.example.demo.startUpTasks;

import com.example.demo.Models.Movie;
import com.example.demo.Repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(MovieRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Movie("Lord of the Rings, The Fellowship of the Ring", "2001", "Frodo's adventure begins", "PG13")));
            log.info("Preloading " + repository.save(new Movie("Spirited Away", "2001", "Chihiro's Journey", "PG13")));
        };
    }
}
