package com.example.demo.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import java.net.URI;
import java.net.URISyntaxException;

import com.example.demo.Exceptions.MovieNotFoundException;
import com.example.demo.Models.Movie;
import com.example.demo.Repositories.MovieRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.IanaLinkRelations;

@RestController
public class MovieController {
    private final MovieRepository movieRepository;

    MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Aggregate root

    @GetMapping("/api/movies/{id}")
    EntityModel<Movie> one(@PathVariable Long id) {

        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));

        return new EntityModel<>(movie, linkTo(methodOn(MovieController.class).one(id)).withSelfRel(),
                linkTo(methodOn(MovieController.class).all()).withRel("movies"));
    }

    @GetMapping("/api/movies")
    ResponseEntity<CollectionModel<EntityModel<Movie>>> all() {
        List<EntityModel<Movie>> movies = movieRepository.findAll().stream()
                .map(movie -> new EntityModel<>(movie,
                        linkTo(methodOn(MovieController.class).one(movie.getId())).withSelfRel(),
                        linkTo(methodOn(MovieController.class).all()).withRel("movies")))
                .collect(Collectors.toList());

        return ResponseEntity
                .ok(new CollectionModel<>(movies, linkTo(methodOn(MovieController.class).all()).withSelfRel()));
    }

    @PostMapping("/api/movie")
    ResponseEntity<?> newMovie(@Valid @RequestBody Movie movie) {
        try {
            Movie savedMovie = movieRepository.save(movie);
            EntityModel<Movie> movieResource = new EntityModel<>(savedMovie,
                    linkTo(methodOn(MovieController.class).one(savedMovie.getId())).withSelfRel());

            return ResponseEntity.created(new URI(movieResource.getRequiredLink(IanaLinkRelations.SELF).getHref())) //
                    .body(movieResource);
        } catch (URISyntaxException e) {
            return ResponseEntity.badRequest().body("Unable to create " + movie);
        }
    }
}
