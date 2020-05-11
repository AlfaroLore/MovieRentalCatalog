package com.example.demo.Controllers;

import java.util.List;

import com.example.demo.Models.MovieRental;
import com.example.demo.Repositories.MovieRentalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieRentalRepository repository;

    MovieController(MovieRentalRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/api/movies")
    List<MovieRental> all() {
        return repository.findAll();
    }
}
