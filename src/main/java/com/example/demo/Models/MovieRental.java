package com.example.demo.Models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import java.util.Date;

@Data
@Entity
public class MovieRental {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "memberID")
    private Member member;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "movieCatalogID")
    private MovieCatalog movieCatalog;

    private Date toReturnDate;

    private Date returnedDate;

    private String status = null;

    MovieRental() {
    }

    public MovieRental(Member member, MovieCatalog movieCatalog, Date toReturnDate, String status) {
        this.member = member;
        this.movieCatalog = movieCatalog;
        this.toReturnDate = toReturnDate;
        this.status = status;
    }
}
