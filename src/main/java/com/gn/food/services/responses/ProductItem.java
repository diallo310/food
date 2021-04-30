package com.gn.food.services.responses;

import java.util.Objects;

public class ProductItem {
    private final String name;
    private final double price;
    private final int quantity;
    private final String picture;
    private final String description;
    private final CategoryItem categoryItem;

    public ProductItem(String name, double price, int quantity, String picture, String description, CategoryItem categoryItem) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.picture = picture;
        this.description = description;
        this.categoryItem = categoryItem;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }

    public CategoryItem getCategoryItem() {
        return categoryItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductItem that = (ProductItem) o;
        return Double.compare(that.price, price) == 0 && quantity == that.quantity && Objects.equals(name, that.name) && Objects.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity, picture);
    }
}
