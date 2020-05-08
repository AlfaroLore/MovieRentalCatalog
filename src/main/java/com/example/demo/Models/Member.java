package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Member {
    private @Id @GeneratedValue Long id;
    private String username;
    private String name;
    private String telephone;

    @OneToOne(mappedBy = "member")
    private MovieRental movieRental;

    public Member() {
    }

    public Member(String username, String name, String telephone) {
        this.username = username;
        this.name = name;
        this.telephone = telephone;
    }

}
