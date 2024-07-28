package org.jointheleague.api.crocodile.Crocodile.Search.presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class HomeCreationTest {
    private HomeCreation homeCreation;
    @BeforeEach
    void setUp() {
        homeCreation = new HomeCreation();
    }
    @Test
    void whenHome_thenReturnRedirect() {
        //given
        String expected = "redirect:swagger-ui.html";
        //when
        String actual = homeCreation.home();
        //then
        assertEquals(expected, actual);
    }
}
