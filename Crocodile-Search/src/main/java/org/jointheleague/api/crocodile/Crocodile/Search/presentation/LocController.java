package org.jointheleague.api.crocodile.Crocodile.Search.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.jointheleague.api.crocodile.Crocodile.Search.repository.dto.Result;
import org.jointheleague.api.crocodile.Crocodile.Search.service.LocService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class LocController {
    private final LocService locService;

    public LocController(LocService locService) {
        this.locService = locService;
    }

    @GetMapping("/searchLocResults")
    @Operation(summary = "Searches for books matching the search term",
            description = "Response may include multiple Result values.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Result(s) found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Result.class))}),
            @ApiResponse(responseCode = "404", description = "Result(s) not found")

    })

    public List<Result> getResults(@RequestParam(value = "q") String query) {
        List<Result> results = locService.getResults(query);
        if (CollectionUtils.isEmpty(results)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result(s) not found.");
        }
        return results;
    }

}