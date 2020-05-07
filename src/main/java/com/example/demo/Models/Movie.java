package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Movie {
    private @Id @GeneratedValue Long id;
    private String title;
    private String year;
    private String description;
    private String rate;// enum
    private Boolean deleted;
    /*
     * private User registeringUser; private User updatingUser; private List<Actor>
     * actorsList;
     */

    public Movie() {
    }

    public Movie(String title, String year, String description, String rate) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.rate = rate;
        this.deleted = false;
    }
}
