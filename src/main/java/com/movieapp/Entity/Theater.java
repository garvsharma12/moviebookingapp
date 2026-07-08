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
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theaterName;
    private String theaterLocation;
    private String theaterCapacity;
    private String theaterScreenType;

    @OneToMany(mappedBy = "theater", fetch = jakarta.persistence.FetchType.LAZY)
    List<Show> show;
}