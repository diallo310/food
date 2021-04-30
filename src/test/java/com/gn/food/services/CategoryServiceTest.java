package com.gn.food.services;

import com.gn.food.dao.models.Category;
import com.gn.food.dao.repositories.CategoryRepository;
import com.gn.food.services.impl.DefaultCategoryService;
import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private DefaultCategoryService defaultCategoryService;

    @Test
    @DisplayName("should create new category")
    void shouldCreateNewCategory() {
        final Category categoryExpected = new Category(1, "Alimentation");

        when(categoryRepository.save(any())).thenReturn(categoryExpected);

        CategoryItem categoryItemActual = defaultCategoryService.create(new CategoryRequestCreate("Alimentation"));

        assertEquals(categoryExpected.getCategoryId(), categoryItemActual.getCategoryId());
        assertEquals(categoryExpected.getName(), categoryItemActual.getName());

        verify(categoryRepository).save(new Category("Alimentation"));
        verifyNoMoreInteractions(categoryRepository);

    }
}
