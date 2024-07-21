package org.jointheleague.api.crocodile.Crocodile.Search.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LocResponse {

    public List<Result> results = null;
    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }
}
