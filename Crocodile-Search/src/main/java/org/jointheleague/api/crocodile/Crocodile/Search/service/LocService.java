package org.jointheleague.api.crocodile.Crocodile.Search.service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LocService {
    private final LocService locService;

    public LocService(LocService locService) {
        this.locService = locService;
    }

    public String getResults(@RequestParam(value="q") String query){
        return locService.getResults(query);
    }
}
