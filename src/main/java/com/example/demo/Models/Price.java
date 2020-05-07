package com.example.demo.Models;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Price {

    private @Id @GeneratedValue Long id;
    private Double price;
    private Date date;

    Price() {
    }

    Price(Double price, Date date) {
        this.price = price;
    }
}
