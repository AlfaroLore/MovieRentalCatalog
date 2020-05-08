package com.example.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import java.util.Date;

@Data
@Entity
public class MovieRental {

    private @Id @GeneratedValue Long id;

    @OneToOne
    @JoinColumn(name = "memberID")
    private Member member;

    @OneToOne
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
