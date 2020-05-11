package com.example.demo.Models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.Set;

@Data
@Entity
public class Movie {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 50, message = "Title max length is 50 characters")
    private String title;

    @NotBlank(message = "Year is mandatory")
    private String year;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 100, message = "Description min length is 100 characters")
    private String description;

    private MovieRate rate = MovieRate.G;// enum
    private Boolean deleted;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registeringUser")
    private User user;
    // private User updatingUser;

    @OneToMany(mappedBy = "movie")
    private Set<Actor> actorsList;

    @JsonIgnore
    @OneToOne(mappedBy = "movie")
    private MovieCatalog movieCatalog;

    public Movie() {
    }

    public Movie(String title, String year, String description, MovieRate rate, Set<Actor> actorsList) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.rate = rate;
        this.deleted = false;
        this.actorsList = actorsList;
    }

    public Long getId() {
        return id;
    }

    public void setMovieCatalog(MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    public void setRegisteringUser(User user) {
        this.user = user;
    }
}
