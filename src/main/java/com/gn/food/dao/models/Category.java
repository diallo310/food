package com.gn.food.dao.models;

public class Category {
    private Integer categoryId;
    private String name;
    private String variant;


    public Category(Integer categoryId, String name, String variant) {
        this.categoryId = categoryId;
        this.name = name;
        this.variant = variant;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
