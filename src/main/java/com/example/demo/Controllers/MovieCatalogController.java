package com.example.demo.Controllers;

import javax.validation.Valid;

import com.example.demo.Models.MovieCatalog;
import com.example.demo.Repositories.MovieCatalogRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieCatalogController {
    private final MovieCatalogRepository movieCatalogRepository;

    public MovieCatalogController(MovieCatalogRepository repository) {
        this.movieCatalogRepository = repository;
    }

    @PostMapping("/api/catalog-entry")
    MovieCatalog newMember(@Valid @RequestBody MovieCatalog movieCatalog) {
        return movieCatalogRepository.save(movieCatalog);
    }
}
