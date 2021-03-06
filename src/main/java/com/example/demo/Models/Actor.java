package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Data
@Entity
public class Actor {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
