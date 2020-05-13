package com.example.demo.Repositories;

import com.example.demo.Models.MovieCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, Long> {
}
