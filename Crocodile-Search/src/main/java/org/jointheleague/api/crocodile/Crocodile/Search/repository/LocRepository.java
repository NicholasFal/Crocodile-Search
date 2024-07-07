package org.jointheleague.api.crocodile.Crocodile.Search.repository;

import org.jointheleague.api.crocodile.Crocodile.Search.service.LocService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class LocRepository {
    private final WebClient webClient;
    public static final String baseUrl = "https://www.loc.gov/collections/?fo=json&at=results";

    public LocRepository(LocRepository locRepository) {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }
    public String getResults(String query){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("fo", "json")
                        .queryParam("at", "results")
                        .queryParam("q", query)
                        .build()
                )
                .retrieve()
                .bodyToMono(dto)
                .block()
                .getResults();
    }
}
