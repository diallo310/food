package com.gn.food.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.controllers.CategoryController;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("CategoryController Test")
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {
    @MockBean
    private CategoryService categoryService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Should create new Category")
    void shouldCreateNewCategory() throws Exception {
        CategoryItem categoryItemExpected = new CategoryItem(1, "Alimentation", null);

        when(categoryService.create(any())).thenReturn(categoryItemExpected);

        mockMvc.perform(
                post("/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CategoryRequestCreate("Alimentation"))))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"categoryId\":1,\"name\":\"Alimentation\",\"variants\":null}"));

        verify(categoryService).create(new CategoryRequestCreate("Alimentation"));
        verifyNoMoreInteractions(categoryService);
    }

    @Test
    @DisplayName("Should return all categories")
    public void shouldReturnAllCategories() throws Exception {
        List<CategoryItem> categoriesItemExpected = Arrays.asList(new CategoryItem(1, "Alimentations", Collections.emptyList()), new CategoryItem(2, "Livres", Collections.emptyList()));

        when(categoryService.findAll()).thenReturn(categoriesItemExpected);

        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"categoryId\":1,\"name\":\"Alimentations\",\"variants\":[]},{\"categoryId\":2,\"name\":\"Livres\",\"variants\":[]}]"));

        verify(categoryService).findAll();
        verifyNoMoreInteractions(categoryService);
    }

}
