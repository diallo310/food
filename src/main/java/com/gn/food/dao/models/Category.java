package com.gn.food.dao.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;
    private String variant;
    @OneToMany(mappedBy = "category")
    private List<Product>products;

    public Category(String name, String variant) {
        this.name = name;
        this.variant = variant;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }
}
