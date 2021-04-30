package com.gn.food.services.impl;

import com.gn.food.services.interfaces.ProductService;
import com.gn.food.services.requests.ProductRequest;
import com.gn.food.services.responses.ProductItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class DefaultProductService implements ProductService {
    @Override
    public void create(ProductRequest productRequest) {

    }

    @Override
    public Optional<ProductItem> findById(int productId) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductItem> update(ProductRequest productRequest) {
        return Optional.empty();
    }

    @Override
    public Page<ProductItem> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(int productId) {

    }

    @Override
    public void findByPrice(double price) {

    }
}
