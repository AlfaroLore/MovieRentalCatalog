package com.example.demo.Repositories;

import com.example.demo.Models.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRentalRepository extends JpaRepository<MovieRental, Long> {
}
