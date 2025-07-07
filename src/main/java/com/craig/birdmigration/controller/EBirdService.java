package com.craig.birdmigration.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Provides methods for fetching recent bird observations from the eBird API by region code.
*/

@Service
public class EBirdService {
    @Value("${ebird.api.token}")
    private String apiKey;

    private final String BASE_URL = "https://api.ebird.org/v2/data/obs";

    /**
     * Fetches recent bird observations from a given region (e.g., "CA", "KZ").
    */

    public String getRecentObservations(String regionCode) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-eBirdApiToken", API_KEY);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = BASE_URL + "/" + regionCode + "/recent";

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}
