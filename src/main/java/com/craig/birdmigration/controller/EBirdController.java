package com.craig.birdmigration.controller;

import com.craig.birdmigration.model.Bird;
import com.craig.birdmigration.repository.BirdRepository;
import com.craig.birdmigration.dto.EBirdObservation;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Provides fallback search using the eBird API when no matching birds are found locally.
*/

@RestController
@RequestMapping("/api/ebird")
public class EBirdController {

    private final BirdRepository birdRepository;
    private final RestTemplate restTemplate;

    public EBirdController(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
        this.restTemplate = new RestTemplate();
    }

    /**
     * Searches for birds by common name.
     * If no local matches are found, fetches results from the eBird API and saves them.
    */

    @GetMapping("/bird/{name}")
    public List<Bird> getBirdByName(@PathVariable String name) {
        List<Bird> birds = birdRepository.findByCommonNameContainingIgnoreCase(name);

        if (birds.isEmpty()) {
            String url = "https://api.ebird.org/v2/data/obs/CA/recent"; // Change 'CA' as needed

            HttpHeaders headers = new HttpHeaders();
            String apiToken = System.getenv("EBIRD_API_TOKEN");
            headers.set("X-eBirdApiToken", apiToken);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<EBirdObservation[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                EBirdObservation[].class
            );

            EBirdObservation[] observations = response.getBody();

            if (observations != null) {
                birds = Arrays.stream(observations)
                        .filter(obs -> obs.getComName().toLowerCase().contains(name.toLowerCase()))
                        .map(obs -> {
                            Bird bird = new Bird();
                            bird.setCommonName(obs.getComName());
                            bird.setScientificName(obs.getSciName());
                            bird.setFamily("Unknown");
                            return bird;
                        })
                        .collect(Collectors.toList());

                birdRepository.saveAll(birds);
            }
        }

        return birds;
    }
}
