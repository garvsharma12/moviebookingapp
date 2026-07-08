package com.movieapp.DTO;

import lombok.Data;

@Data
public class TheaterDTO {
    private Long id;
    private String theaterName;
    private String theaterLocation;
    private String theaterCapacity;
    private String theaterScreenType;

}
