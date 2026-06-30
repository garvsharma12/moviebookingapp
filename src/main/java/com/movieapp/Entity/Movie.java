package com.movieapp.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String genre;
    private Integer duration; // Duration in minutes
    private String language;
    private java.time.LocalDate releaseDate;

    @OneToMany(mappedBy = "movie", fetch = jakarta.persistence.FetchType.LAZY)
    private List<Show> shows; // List of shows for this movie
}
