package com.movieapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.DTO.MovieDTO;
import com.movieapp.Entity.Movie;
import com.movieapp.Service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @PostMapping("/addmovie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        // Logic to create a new movie using the MovieService
        // You can call a method in MovieService to save the movie
        return ResponseEntity.ok(movieService.addMovie(movieDTO));
    }

    @GetMapping("/getallmovies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        // Logic to retrieve all movies using the MovieService
        // You can call a method in MovieService to fetch all movies
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/getmoviesbygenre")
    public ResponseEntity<List<Movie>> getMovieByGenre(@RequestParam String genre) {
        // Logic to retrieve movies by genre using the MovieService
        // You can call a method in MovieService to fetch movies by genre
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/getmoviesbylanguage")
    public ResponseEntity<List<Movie>> getMoviesByLanguage(@RequestParam String language) {
        // Logic to retrieve movies by language using the MovieService
        // You can call a method in MovieService to fetch movies by language
        return ResponseEntity.ok(movieService.getMoviesByLanguage(language));
    }

    @GetMapping("/getmoviebytitle")
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title) {
        // Logic to retrieve a movie by title using the MovieService
        // You can call a method in MovieService to fetch a movie by title
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }

    @PutMapping("/updatemovie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        // Logic to update a movie using the MovieService
        // You can call a method in MovieService to update the movie
        return ResponseEntity.ok(movieService.updateMovie(id, movieDTO));
    }

    @DeleteMapping("/deletemovie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        // Logic to delete a movie using the MovieService
        // You can call a method in MovieService to delete the movie
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
