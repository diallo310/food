package com.gn.food.dao.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories", uniqueConstraints = {@UniqueConstraint(columnNames = "variant"), @UniqueConstraint(columnNames = "name")})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;
    @OneToMany
    private List<Variant> variant;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String name, List<Variant> variant) {
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

    public List<Variant> getVariant() {
        return variant;
    }

    public void setVariant(List<Variant> variant) {
        this.variant = variant;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
