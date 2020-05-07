package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Actor {
    private @Id @GeneratedValue Long id;
    private String name;

    Actor() {
    }

    Actor(String name) {
        this.name = name;
    }
}
