package com.movieapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.Entity.Movie;   

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // You can define custom query methods here if needed
    Optional<List<Movie>> findByGenre(String genre);
    Optional<List<Movie>> findByLanguage(String language);
    Optional<Movie> findByTitle(String title);
}