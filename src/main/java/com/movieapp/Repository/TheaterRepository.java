package com.movieapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.Entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    
    Optional<List<Theater>> findByLocation(String location);
    
}
