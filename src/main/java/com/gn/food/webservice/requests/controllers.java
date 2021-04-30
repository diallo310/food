package com.gn.food.webservice.requests;

import com.gn.food.services.interfaces.CategoryService;
import com.gn.food.services.responses.CategoryItem;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categories")
public class controllers {
    private final CategoryService categoryService;

    public controllers(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryItem create(@Valid @RequestBody CategoryRequestCreate categoryRequestCreate){
        return categoryService.create(categoryRequestCreate);
    }
}
