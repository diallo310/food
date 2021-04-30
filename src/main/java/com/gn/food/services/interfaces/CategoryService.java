package com.gn.food.services.interfaces;

import com.gn.food.services.requests.CategoryRequest;
import com.gn.food.services.responses.CategoryItem;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void create(CategoryRequest categoryRequest);

    Optional<CategoryItem> findById();

    Optional<CategoryItem> update(int categoryId, CategoryRequest categoryRequest);

    List<CategoryItem> findAll(Pageable pageable);

    void delete(int categoryId);
}
