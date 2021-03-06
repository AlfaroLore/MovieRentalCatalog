package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class User {

    private @Id @GeneratedValue Long id;
    private String name;

    @OneToOne(mappedBy = "user")
    private Movie movie;

    User() {
    }

    User(String name) {
        this.name = name;
    }
}
