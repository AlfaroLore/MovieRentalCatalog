package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Member {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @NotBlank(message = "Username is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 150, message = "Username max length is 150 characters")
    private String username;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name max length is 100 characters")
    private String name;

    private String telephone;

    @JsonIgnore
    @OneToOne(mappedBy = "member")
    private MovieRental movieRental;

    public Member() {
    }

    public Member(String username, String name, String telephone) {
        this.username = username;
        this.name = name;
        this.telephone = telephone;
    }

    public void setMovieRental(MovieRental movieRental) {
        this.movieRental = movieRental;
    }
}
