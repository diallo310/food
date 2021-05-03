package com.gn.food.services.impl;

import com.gn.food.dao.models.Category;
import com.gn.food.dao.repositories.CategoryRepository;
import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import com.gn.food.webservice.requests.CategoryRequestUpdate;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;

    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryItem create(CategoryRequestCreate categoryRequestCreate) {
        final Category category = new Category(categoryRequestCreate.getName());
        return categoryItemMapper(categoryRepository.save(category));
    }

    @Override
    public Optional<CategoryItem> findById(int categoryId) {
        return categoryRepository.findById(categoryId).map(this::categoryItemMapper);
    }

    @Override
    public Optional<CategoryItem> update(int categoryId, CategoryRequestUpdate categoryRequestUpdate) {
        final Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        return categoryOptional.map(category -> {
            category.setName(categoryRequestUpdate.getName());
            category.setVariant(categoryRequestUpdate.getVariants());
            return categoryRepository.save(category);
        }).map(this::categoryItemMapper);
    }

    @Override
    public List<CategoryItem> findAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(),false)
                .map(this::categoryItemMapper)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int categoryId) {

    }

    private CategoryItem categoryItemMapper(Category category) {
        return new CategoryItem(category.getCategoryId(), category.getName(), category.getVariant());
    }
}
