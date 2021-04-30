package com.gn.food.dao.repositories;

import com.gn.food.dao.models.Variant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends CrudRepository<Variant, Integer> {
}
