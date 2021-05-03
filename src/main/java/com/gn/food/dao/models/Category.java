package com.gn.food.dao.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Categories", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;
    @OneToMany
    private List<Variant> variants;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category(final int categoryId, final String name, final List<Variant> variants) {
        this.categoryId = categoryId;
        this.name = name;
        this.variants = variants;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Variant> getVariant() {
        return variants;
    }

    public void setVariant(List<Variant> variants) {
        this.variants = variants;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId && Objects.equals(name, category.name) && Objects.equals(variants, category.variants) && Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, variants, products);
    }
}
