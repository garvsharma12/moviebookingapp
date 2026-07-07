package com.movieapp.Service;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.DTO.MovieDTO;
import com.movieapp.Entity.Movie;
import com.movieapp.Repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setReleaseDate(movieDTO.getReleaseDate());

        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    
    public List<Movie> getMoviesByGenre(String genre){
        return movieRepository.findByGenre(genre).orElseThrow(() -> new RuntimeException("Movies not found for genre: " + genre)) ;
    }

    public List<Movie> getMoviesByLanguage(String language){
        return movieRepository.findByLanguage(language).orElseThrow(() -> new RuntimeException("Movies not found for language: " + language)) ;
    }
}
