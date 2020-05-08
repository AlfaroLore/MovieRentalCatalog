package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Data
@Entity
public class Actor {
    private @Id @GeneratedValue Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }
}
