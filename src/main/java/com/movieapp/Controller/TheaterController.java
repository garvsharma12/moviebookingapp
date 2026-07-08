package com.movieapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.DTO.TheaterDTO;
import com.movieapp.Service.TheaterService;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {
    
    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheater")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TheaterDTO> addTheater(@RequestBody TheaterDTO theaterDTO) {
        // Implement the logic to add a theater using theaterService
        return ResponseEntity.ok(theaterService.addTheater(theaterDTO));
    }

    @GetMapping("/getTheaterByLocation")
    public ResponseEntity<List<TheaterDTO>> getTheaterByLocation(@RequestParam String Location) {
        // Implement the logic to get a theater by location using theaterService
        return ResponseEntity.ok(theaterService.getTheaterByLocation(Location)); 
    }

    
}
