package com.example.demo.Models;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

@Data
@Entity
public class Price {

    private @Id @GeneratedValue Long id;
    private Double price;
    private Date date;

    @JsonIgnore
    @OneToOne(mappedBy = "price")
    private MovieCatalog movieCatalog;

    Price() {
    }

    public Price(Double price, Date date) {
        this.price = price;
        this.date = date;
    }

    public void setMovieCatalog(MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }
}
