package com.gn.food.services.impl;

import com.gn.food.dao.models.Category;
import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import com.gn.food.webservice.requests.CategoryRequestUpdate;
import com.gn.food.services.responses.CategoryItem;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class DefaultCategoryService implements CategoryService {
    @Override
    public void create(CategoryRequestCreate categoryRequestCreate) {
    }

    @Override
    public Optional<CategoryItem> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<CategoryItem> update(int categoryId, CategoryRequestUpdate categoryRequest) {
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
