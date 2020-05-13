package com.example.demo.Services;

import com.example.demo.Models.Movie;

import java.util.List;

public interface MovieService {

    Movie findById(Long id);

    List<Movie> findAll();

    Movie save(Movie movie);

    void deleteById(Long id);

}
