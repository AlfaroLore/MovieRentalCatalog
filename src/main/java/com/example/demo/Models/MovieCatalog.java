package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Data
@Entity
public class MovieCatalog {

    @Id
    @Column(name = "movieID")
    private Long movieID;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "movieID")
    private Movie movie;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "priceID")
    private Price price;

    private int numberOfCopies;

    @OneToOne(cascade = CascadeType.MERGE)
    private MovieRental movieRental;

    public MovieCatalog() {

    }

    public MovieCatalog(Movie movie, Price price, int numberOfCopies) {
        this.movieID = movie.getId();
        this.movie = movie;
        this.price = price;
        this.numberOfCopies = numberOfCopies;
    }

    public void setMovieRental(MovieRental movieRental) {
        this.movieRental = movieRental;
    }
}
