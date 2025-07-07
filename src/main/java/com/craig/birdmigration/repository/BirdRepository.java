package com.craig.birdmigration.repository;

import com.craig.birdmigration.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA interface for interacting with the birds table.
 * Provides basic CRUD and custom search methods.
*/

public interface BirdRepository extends JpaRepository<Bird, Long> {
    List<Bird> findByCommonNameContainingIgnoreCase(String name);
}
