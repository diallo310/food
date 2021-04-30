package com.gn.food.services.responses;

import com.gn.food.dao.models.Variant;

import java.util.List;

public class CategoryItem {
    private final int categoryId;
    private final String  name;
    private final List<Variant>variants;

    public CategoryItem(int categoryId, String name, List<Variant> variants) {
        this.categoryId = categoryId;
        this.name = name;
        this.variants = variants;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public List<Variant> getVariants() {
        return variants;
    }
}
