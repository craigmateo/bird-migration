package com.craig.birdmigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.craig.birdmigration.model.Bird;

public interface BirdRepository extends JpaRepository<Bird, Long> {
}
