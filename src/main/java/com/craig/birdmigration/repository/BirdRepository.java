package com.craig.birdmigration.repository;

import com.craig.birdmigration.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BirdRepository extends JpaRepository<Bird, Long> {
    List<Bird> findByCommonNameContainingIgnoreCase(String name);
}
