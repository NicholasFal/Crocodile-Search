package org.jointheleague.api.crocodile.Crocodile.Search.repository;

import org.jointheleague.api.crocodile.Crocodile.Search.repository.dto.LocResponse;
import org.jointheleague.api.crocodile.Crocodile.Search.repository.dto.Result;
import org.jointheleague.api.crocodile.Crocodile.Search.service.LocService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Repository
public class LocRepository {
    private final WebClient webClient;
    public static final String baseUrl = "https://www.loc.gov/books";

    public LocRepository(WebClient mockClientMock) {
        webClient = mockClientMock;
    }
    public LocRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }
    public List<Result> getResults(String query){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("fo", "json")
                        .queryParam("at", "results")
                        .queryParam("q", query)
                        .build()
                )
                .retrieve()
                .bodyToMono(LocResponse.class)
                .block()
                .getResults();
    }
}
