package com.gn.food.services.interfaces;

import com.gn.food.webservice.requests.ProductRequest;
import com.gn.food.services.responses.ProductItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    void create(ProductRequest productRequest);

    Optional<ProductItem> findById(int productId);

    Optional<ProductItem> update(ProductRequest productRequest);

    Page<ProductItem> findAll(Pageable pageable);

    void delete(int productId);

    void findByPrice(double price);

}
