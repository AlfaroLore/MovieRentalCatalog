package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.Set;

@Data
@Entity
public class Movie {
    private @Id @GeneratedValue Long id;
    private String title;
    private String year;
    private String description;
    private MovieRate rate;// enum
    private Boolean deleted;

    @OneToOne
    @JoinColumn(name = "registeringUser")
    private User user;
    // private User updatingUser;

    @OneToMany(mappedBy = "movie")
    private Set<Actor> actorsList;

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
}
