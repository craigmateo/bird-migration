package com.craig.birdmigration.repository;

import com.craig.birdmigration.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {
}

