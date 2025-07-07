package com.craig.birdmigration.controller;

import com.craig.birdmigration.model.*;
import com.craig.birdmigration.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class SightingController {

    private final BirdRepository birdRepository;
    private final LocationRepository locationRepository;
    private final SightingRepository sightingRepository;

    public SightingController(BirdRepository birdRepository,
                              LocationRepository locationRepository,
                              SightingRepository sightingRepository) {
        this.birdRepository = birdRepository;
        this.locationRepository = locationRepository;
        this.sightingRepository = sightingRepository;
    }

    @PostMapping("/sightings")
    public ResponseEntity<Sighting> recordSighting(@RequestBody SightingRequest request) {
        // Check or create bird
        Bird bird = birdRepository.findByCommonNameContainingIgnoreCase(request.getBirdName())
                .stream().findFirst().orElse(null);
        if (bird == null) {
            bird = new Bird();
            bird.setCommonName(request.getBirdName());
            bird.setFamily("Unknown");
            bird.setScientificName("Unknown");
            bird = birdRepository.save(bird);
        }

        // Check or create location
        Location location = locationRepository.findByNameAndCountry(request.getLocationName(), request.getCountry())
                .orElseGet(() -> {
                    Location newLocation = new Location();
                    newLocation.setName(request.getLocationName());
                    newLocation.setCountry(request.getCountry());
                    newLocation.setLatitude(request.getLatitude());
                    newLocation.setLongitude(request.getLongitude());
                    return locationRepository.save(newLocation);
                });

        // Create and save sighting
        Sighting sighting = new Sighting();
        sighting.setBird(bird);
        sighting.setLocation(location);
        sighting.setObserverName(request.getObserverName());
        sighting.setSightingDate(LocalDate.parse(request.getSightingDate()));
        sighting.setRouteId(request.getRouteId());

        return ResponseEntity.ok(sightingRepository.save(sighting));
    }
}
