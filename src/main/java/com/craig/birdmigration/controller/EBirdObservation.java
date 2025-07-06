package com.craig.birdmigration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EBirdObservation {

    @JsonProperty("speciesCode")
    private String speciesCode;

    @JsonProperty("comName")
    private String comName;

    @JsonProperty("sciName")
    private String sciName;

    // Getters and setters
    public String getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getSciName() {
        return sciName;
    }

    public void setSciName(String sciName) {
        this.sciName = sciName;
    }
}

