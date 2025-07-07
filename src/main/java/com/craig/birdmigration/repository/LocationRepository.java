package com.craig.birdmigration.repository;

import com.craig.birdmigration.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByNameAndCountry(String name, String country);
}

