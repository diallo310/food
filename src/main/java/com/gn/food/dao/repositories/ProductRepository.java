package com.gn.food.dao.repositories;

import com.gn.food.dao.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
