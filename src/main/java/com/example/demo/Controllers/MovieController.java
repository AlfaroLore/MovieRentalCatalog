package com.example.demo.Controllers;

import java.util.List;

import com.example.demo.Models.Movie;
import com.example.demo.Repositories.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieRepository repository;

    MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/api/movies")
    List<Movie> all() {
        return repository.findAll();
    }
}
