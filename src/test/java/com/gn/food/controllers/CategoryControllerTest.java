package com.gn.food.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.controllers.CategoryController;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import com.gn.food.webservice.requests.CategoryRequestUpdate;
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
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    @DisplayName("Should return Category with given Id")
    void shouldReturnCategoryWithGivenId() throws Exception {
        CategoryItem categoryItemExpected = new CategoryItem(1, "Alimentations", Collections.emptyList());

        when(categoryService.findById(anyInt())).thenReturn(Optional.of(categoryItemExpected));

        mockMvc.perform(get("/categories/{categoryId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.categoryId", is(categoryItemExpected.getCategoryId())))
                .andExpect(jsonPath("$.name", is(categoryItemExpected.getName())))
                .andExpect(jsonPath("$.variants", is(categoryItemExpected.getVariants())));

        verify(categoryService).findById(1);
        verifyNoMoreInteractions(categoryService);
    }

    @Test
    @DisplayName("Should return category with updated name")
    void shouldReturnCategoryWithUpdatedName() throws Exception {
        CategoryItem categoryItemExpected = new CategoryItem(1, "Alimentations", Collections.emptyList());

        when(categoryService.update(anyInt(), any())).thenReturn(Optional.of(categoryItemExpected));

        mockMvc.perform(patch("/categories/{categoryId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new CategoryRequestUpdate("Alimentations", Collections.emptyList()))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryId", is(categoryItemExpected.getCategoryId())))
                .andExpect(jsonPath("$.name", is(categoryItemExpected.getName())))
                .andExpect(jsonPath("$.variants", is(categoryItemExpected.getVariants())));

        verify(categoryService).update(1, new CategoryRequestUpdate("Alimentations", Collections.emptyList()));
        verifyNoMoreInteractions(categoryService);
    }

}
