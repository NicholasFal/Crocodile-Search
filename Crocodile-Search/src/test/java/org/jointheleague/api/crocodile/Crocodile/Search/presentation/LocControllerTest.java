package org.jointheleague.api.crocodile.Crocodile.Search.presentation;


import org.jointheleague.api.crocodile.Crocodile.Search.service.LocService;
import org.jointheleague.api.crocodile.Crocodile.Search.repository.dto.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocControllerTest {
    private LocController locController;

    @Mock
    private LocService locService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        locController = new LocController(locService);
    }
    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Java";
        Result result = new Result();
        result.setTitle("TITLE");
        result.setLink("LINK");
        result.setAuthors(Collections.singletonList("AUTHORS"));
        //when
        List<Result> actualResults = locController.getResults(query);

        //then
        assertEquals(result, actualResults);
    }

    @Test
    void givenBadQuery_whenGetResults_thenThrowsException() {
    //given
    String query = "Java";
     //when

     //then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> locController.getResults(query));
        assertEquals(exceptionThrown.getMessage(), "404 NOT_FOUND \"Result(s) not found.\"");
    }
}
