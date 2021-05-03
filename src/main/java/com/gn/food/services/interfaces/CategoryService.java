package com.gn.food.services.interfaces;

import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import com.gn.food.webservice.requests.CategoryRequestUpdate;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryItem create(CategoryRequestCreate categoryRequestCreate);

    Optional<CategoryItem> findById(int categoryId);

    Optional<CategoryItem> update(int categoryId, CategoryRequestUpdate categoryRequestUpdate);

    List<CategoryItem> findAll();

    void delete(int categoryId);
}
