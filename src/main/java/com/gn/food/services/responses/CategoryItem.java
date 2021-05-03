package com.gn.food.services.responses;

import com.gn.food.dao.models.Variant;

import java.util.List;
import java.util.Objects;

public class CategoryItem {
    private final int categoryId;
    private final String name;
    private final List<Variant> variants;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryItem that = (CategoryItem) o;
        return categoryId == that.categoryId && Objects.equals(name, that.name) && Objects.equals(variants, that.variants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, variants);
    }
}
