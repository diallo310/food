package com.gn.food.webservice.controllers;

import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.services.responses.CategoryItem;
import com.gn.food.webservice.requests.CategoryRequestCreate;
import com.gn.food.webservice.requests.CategoryRequestUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<CategoryItem> findAll() {
        return categoryService.findAll();
    }

    @PatchMapping("/{categoryId}")
    public ResponseEntity<CategoryItem> update(@PathVariable("categoryId") int categoryId, @Valid @RequestBody CategoryRequestUpdate categoryRequestUpdate) {
        return ResponseEntity.of(categoryService.update(categoryId, categoryRequestUpdate));
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("categoryId") int categoryId) {
        categoryService.deleteById(categoryId);
    }

}
