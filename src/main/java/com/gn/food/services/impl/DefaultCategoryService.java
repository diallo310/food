package com.gn.food.services.impl;

import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.services.requests.CategoryRequest;
import com.gn.food.services.responses.CategoryItem;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class DefaultCategoryService implements CategoryService {
    @Override
    public void create(CategoryRequest categoryRequest) {
        
    }

    @Override
    public Optional<CategoryItem> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<CategoryItem> update(int categoryId, CategoryRequest categoryRequest) {
        return Optional.empty();
    }

    @Override
    public List<CategoryItem> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(int categoryId) {

    }
}
