package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Data
@Entity
public class MovieCatalog {

    @Id
    @Column(name = "movieID", insertable = false, updatable = false)
    private Long movieID;

    @OneToOne
    @JoinColumn(name = "movieID")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "priceID")
    private Price price;

    private int numberOfCopies;

    @OneToOne(mappedBy = "movieCatalog")
    private MovieRental movieRental;

    public MovieCatalog(Movie movie, Price price, int numberOfCopies) {
        this.movie = movie;
        this.price = price;
        this.numberOfCopies = numberOfCopies;
    }
}
