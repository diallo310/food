package com.gn.food.dao.repositories;

import com.gn.food.dao.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
