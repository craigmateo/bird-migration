package com.craig.birdmigration.dto;

public class SightingRequest {
    private String observerName;
    private String birdCommonName;
    private String locationName;
    private String country;  // <- add this if missing
    private double latitude;
    private double longitude;
    private String sightingDate;
    private Long routeId;

    // Getters and setters
    public String getObserverName() { return observerName; }
    public void setObserverName(String observerName) { this.observerName = observerName; }

    public String getBirdCommonName() { return birdCommonName; }
    public void setBirdCommonName(String birdCommonName) { this.birdCommonName = birdCommonName; }

    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }

    public String getCountry() { return country; }        // <- ensure this getter exists
    public void setCountry(String country) { this.country = country; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getSightingDate() { return sightingDate; }
    public void setSightingDate(String sightingDate) { this.sightingDate = sightingDate; }

    public Long getRouteId() {
    return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}

