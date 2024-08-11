package org.jointheleague.api.crocodile.Crocodile.Search.service;

import org.jointheleague.api.crocodile.Crocodile.Search.repository.LocRepository;
import org.jointheleague.api.crocodile.Crocodile.Search.repository.dto.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocServiceTest {
    private LocService locService;

    @Mock
    private LocRepository locRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        locService = new LocService(locRepository);
    }

    @Test
    void whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Java";
        Result result = new Result();
        result.setTitle("TITLE");
        result.setLink("LINK");
        result.setAuthors(Collections.singletonList("AUTHORS"));
        List<Result> expectedResults = Collections.singletonList(result);
        //when
        List<Result> actualResults = locService.getResults(query);

        //then
        assertEquals(result, actualResults);
    }
}
