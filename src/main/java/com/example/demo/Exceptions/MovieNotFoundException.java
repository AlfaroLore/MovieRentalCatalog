package com.example.demo.Exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Could not found movie " + id);
    }
}
