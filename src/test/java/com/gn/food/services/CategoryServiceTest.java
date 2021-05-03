package com.gn.food.services;

import com.gn.food.dao.models.Category;
import com.gn.food.dao.repositories.CategoryRepository;
import com.gn.food.services.impl.DefaultCategoryService;
import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


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

    @Test
    @DisplayName("Should return Category with this ID")
    void shouldReturnCategoryWithThisId() {
        when(categoryRepository.findById(1)).thenReturn(Optional.of(new Category(1, "Alimentation")));

        Optional<CategoryItem> categoryItemActualOptional = defaultCategoryService.findById(1);

        assertThat(categoryItemActualOptional.isPresent(), is(true));

        CategoryItem categoryItemActual = categoryItemActualOptional.get();

        assertThat(categoryItemActual.getCategoryId(), is(1));
        assertThat(categoryItemActual.getName(), is("Alimentation"));

        verify(categoryRepository).findById(1);
        verifyNoMoreInteractions(categoryRepository);
    }

}