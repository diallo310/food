package com.gn.food.webservice.controllers;

import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryItem create(@Valid @RequestBody CategoryRequestCreate categoryRequestCreate) {
        return categoryService.create(categoryRequestCreate);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryItem> findById(@PathVariable("categoryId") int categoryId) {
        return ResponseEntity.of(categoryService.findById(categoryId));
    }
}
