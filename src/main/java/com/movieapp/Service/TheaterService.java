package com.movieapp.Service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.DTO.TheaterDTO;
import com.movieapp.Entity.Theater;
import com.movieapp.Repository.TheaterRepository;

@Service
public class TheaterService {
    
    @Autowired
    private TheaterRepository theaterRepository;

    public Theater addTheater(TheaterDTO theater) {

        Theater newTheater = new Theater();
        newTheater.setName(TheaterDTO.getName());
        newTheater.setLocation(TheaterDTO.getLocation());
        newTheater.setCapacity(TheaterDTO.getCapacity());
        newTheater.setTheaterScreenType(TheaterDTO.getTheaterScreenType());

        return theaterRepository.save(newTheater);
    }

    public List<Theater> getTheaterByLocation(String location) {
        return theaterRepository.findByLocation(location)
                .orElseThrow(() -> new RuntimeException("Theater not found with location: " + location));
    }

    public Theater updateTheater(Long id, TheaterDTO theaterDTO) {
        Theater existingTheater = theaterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found with id: " + id));

        existingTheater.setName(TheaterDTO.getName());
        existingTheater.setLocation(TheaterDTO.getLocation());
        existingTheater.setCapacity(TheaterDTO.getCapacity());
        existingTheater.setTheaterScreenType(TheaterDTO.getTheaterScreenType());

        return theaterRepository.save(existingTheater);
    }

    public void deleteTheater(Long id) {
        Theater existingTheater = theaterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found with id: " + id));

        theaterRepository.delete(existingTheater);
    }
}
