package com.craig.birdmigration.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "sightings")
public class Sighting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bird_id", nullable = false)
    private Bird bird;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    private Long routeId;

    private LocalDate sightingDate;
    private String observerName;

    // Bird getter/setter
    public Bird getBird() {
        return bird;
    }
    public void setBird(Bird bird) {
        this.bird = bird;
    }

    // Location getter/setter
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    // RouteId getter/setter
    public Long getRouteId() {
        return routeId;
    }
    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    // SightingDate getter/setter
    public LocalDate getSightingDate() {
        return sightingDate;
    }
    public void setSightingDate(LocalDate sightingDate) {
        this.sightingDate = sightingDate;
    }

    // ObserverName getter/setter
    public String getObserverName() {
        return observerName;
    }
    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }
}
