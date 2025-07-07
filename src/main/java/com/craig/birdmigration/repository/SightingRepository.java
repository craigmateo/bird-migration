package com.craig.birdmigration.repository;

import com.craig.birdmigration.model.Sighting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SightingRepository extends JpaRepository<Sighting, Long> {
    List<Sighting> findByObserverName(String observerName);
}
