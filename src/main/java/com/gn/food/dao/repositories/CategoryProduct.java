package com.gn.food.dao.repositories;

import com.gn.food.dao.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryProduct extends CrudRepository<Category,Integer> {
}
