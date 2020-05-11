package com.example.demo.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Models.Movie;
import com.example.demo.Models.MovieRental;
import com.example.demo.Repositories.MovieRentalRepository;
import com.example.demo.Repositories.MovieRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieRentalRepository repository;
    private final MovieRepository movieRepository;

    MovieController(MovieRentalRepository repository, MovieRepository movieRepository) {
        this.repository = repository;
        this.movieRepository = movieRepository;
    }

    // Aggregate root

    @GetMapping("/api/movies")
    List<MovieRental> all() {
        return repository.findAll();
    }

    @PostMapping("/api/movie")
    Movie newMovie(@Valid @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
}
