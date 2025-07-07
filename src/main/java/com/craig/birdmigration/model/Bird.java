package com.craig.birdmigration.model;

import jakarta.persistence.*;

/**
 * Represents a bird record in the database.
 * Maps to the 'birds' table via JPA/Hibernate.
 */

@Entity
@Table(name = "birds")
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commonName;
    private String scientificName;
    private String family;

    // Getters and Setters
    public Long getId() { return id; }

    public String getCommonName() { return commonName; }
    public void setCommonName(String commonName) { this.commonName = commonName; }

    public String getScientificName() { return scientificName; }
    public void setScientificName(String scientificName) { this.scientificName = scientificName; }

    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }
}
