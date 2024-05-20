package org.example.controller;

import org.example.model.Cat;
import org.example.model.CatBehaviour;
import org.example.service.CatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CatControllerTest {

    @Mock
    private CatService catService;

    @InjectMocks
    private CatController catController;

    @Test
    public void getAllCats_nominal_noFilters() {
        //GIVEN
        List<Cat> cats = Collections.emptyList();
        given(catService.getAllCats()).willReturn(cats);

        //WHEN -> THEN
        assertEquals(cats, catController.getAllCats(null));
    }

    @Test
    void getCat_nominal() {
        //GIVEN
        String catName = "Tom";
        Cat cat = new Cat(catName, CatBehaviour.CALM);

        given(catService.getCat(anyString())).willReturn(cat);

        //WHEN
        Cat result = catController.getCat(catName);

        //THEN
        assertEquals(cat, result);

        verify(catService, times(2)).getCat(catName);
    }

    @Test
    public void getCat_exceptional_catNotFound() {
        //GIVEN
        String catName = "I don't exist";
        given(catService.getCat(catName)).willReturn(null);

        //WHEN -> THEN
        assertThrows(ResponseStatusException.class,
                     () -> catController.getCat(catName));

        verify(catService).getCat(catName);
    }
}