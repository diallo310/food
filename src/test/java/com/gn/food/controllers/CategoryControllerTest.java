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

import static org.mockito.Mockito.*;
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
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())

                .andExpect(content().json("{\"categoryId\":1,\"name\":\"Alimentation\",\"variants\":null}"));

        verify(categoryService).create(new CategoryRequestCreate("Alimentation"));
        verifyNoMoreInteractions(categoryService);
    }


}
