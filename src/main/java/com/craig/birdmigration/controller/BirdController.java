package com.craig.birdmigration.controller;

import com.craig.birdmigration.model.Bird;
import com.craig.birdmigration.repository.BirdRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Exposes REST endpoints for managing birds stored in the local database.
*/

@RestController
@RequestMapping("/birds")
public class BirdController {

    private final BirdRepository birdRepository;

    public BirdController(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    /**
     * Returns all birds from the local database.
    */
    @GetMapping
    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

    /**
     * Saves a new bird to the local database.
    */
    @PostMapping
    public Bird addBird(@RequestBody Bird bird) {
        return birdRepository.save(bird);
    }
}
