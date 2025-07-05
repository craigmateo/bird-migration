package com.craig.birdmigration.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.craig.birdmigration.model.Bird;
import com.craig.birdmigration.repository.BirdRepository;

@RestController
@RequestMapping("/birds")
public class BirdController {

    private final BirdRepository repository;

    public BirdController(BirdRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Bird> getAllBirds() {
        return repository.findAll();
    }

    @PostMapping
    public Bird addBird(@RequestBody Bird bird) {
        return repository.save(bird);
    }
}
