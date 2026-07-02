package com.movieapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.Entity.Movie;   

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // You can define custom query methods here if needed
}