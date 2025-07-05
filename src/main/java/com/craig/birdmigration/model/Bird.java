package com.craig.birdmigration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bird {
    @Id
    private Long id;
    private String species;
    private String location;
    
    // Getters and setters
}
