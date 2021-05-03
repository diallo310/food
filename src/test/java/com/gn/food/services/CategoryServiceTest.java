package com.gn.food.services;

import com.gn.food.dao.models.Category;
import com.gn.food.dao.repositories.CategoryRepository;
import com.gn.food.services.impl.DefaultCategoryService;
import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import com.gn.food.webservice.requests.CategoryRequestUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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

        final CategoryItem categoryItemActual = defaultCategoryService.create(new CategoryRequestCreate("Alimentation"));

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

        final CategoryItem categoryItemActual = categoryItemActualOptional.get();

        assertThat(categoryItemActual.getCategoryId(), is(1));
        assertThat(categoryItemActual.getName(), is("Alimentation"));

        verify(categoryRepository).findById(1);
        verifyNoMoreInteractions(categoryRepository);
    }

    @Test
    @DisplayName("Should update name the Catagory with this Id")
    void shouldUpdateNameCategoryWithThisId() {

        when(categoryRepository.findById(anyInt())).thenReturn(Optional.of(new Category(1, "Alimentation")));
        when(categoryRepository.save(any())).thenReturn(new Category(1, "Alimentations"));

        final Optional<CategoryItem> categoryItemActualOptional = defaultCategoryService.update(1, new CategoryRequestUpdate("Alimentations", Collections.emptyList()));

        assertThat(categoryItemActualOptional.isPresent(), is(true));

        final CategoryItem categoryItemActual = categoryItemActualOptional.get();

        InOrder inOrder = inOrder(categoryRepository);

        assertThat(categoryItemActual.getName(), is("Alimentations"));

        inOrder.verify(categoryRepository).findById(1);
        inOrder.verify(categoryRepository).save(new Category(1, "Alimentations", Collections.emptyList()));
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    @DisplayName("should return All categories")
    void shouldReturnAllCategories() {
        List<Category> categoriesExpected = Arrays.asList(new Category(1, "Alimentations"), new Category(2, "Vêtements"));

        when(categoryRepository.findAll()).thenReturn(categoriesExpected);

        List<CategoryItem> categoriesItemActual = defaultCategoryService.findAll();

        assertThat(categoriesExpected).usingRecursiveComparison()
                .ignoringFields("products")
                .isEqualTo(categoriesItemActual);

        verify(categoryRepository).findAll();
        verifyNoMoreInteractions(categoryRepository);
    }


}