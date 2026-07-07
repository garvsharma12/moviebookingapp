package com.movieapp.Service;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public Movie getMovieByTitle(String title){
        Optional<Movie> movie = movieRepository.findAll().stream().filter(m -> m.getTitle().equalsIgnoreCase(title)).findFirst();
        if(movie.isPresent()){
            return movie.get();
        }else{
            throw new RuntimeException("Movie not found with title: " + title);
        }
    }

    public Movie updateMovie(Long id, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setReleaseDate(movieDTO.getReleaseDate()); 
        movie.setDescription(movieDTO.getDescription()); 

        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
        movieRepository.delete(movie);
    } 
}
