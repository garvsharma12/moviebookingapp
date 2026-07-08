package com.movieapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.Entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    
}
