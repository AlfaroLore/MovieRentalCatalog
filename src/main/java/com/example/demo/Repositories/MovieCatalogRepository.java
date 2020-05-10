package com.example.demo.Repositories;

import com.example.demo.Models.MovieCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, Long> {
}
