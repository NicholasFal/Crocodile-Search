package org.jointheleague.api.crocodile.Crocodile.Search.presentation;


import org.jointheleague.api.crocodile.Crocodile.Search.service.LocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
public class LocControllerTest {
    private LocController locController;

    @Mock
    private LocService = locService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        locController = new LocController(locService);
    }
    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {

    }

    @Test
    void givenBadQuery_whenGetResults_thenThrowsException() {

    }
}
