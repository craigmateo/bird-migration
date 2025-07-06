package com.craig.birdmigration.controller;

import com.craig.birdmigration.model.Bird;
import com.craig.birdmigration.repository.BirdRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birds")
public class BirdController {

    private final BirdRepository birdRepository;

    public BirdController(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @GetMapping
    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

    @PostMapping
    public Bird addBird(@RequestBody Bird bird) {
        return birdRepository.save(bird);
    }
}
