package com.gn.food.webservice.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProductRequest {
    private final String name;
    private final double price;
    private final int quantity;
    private final String picture;
    private final String description;
    private final int categoryId;

    @JsonCreator
    public ProductRequest(@JsonProperty("name") final String name, @JsonProperty("price") final double price, @JsonProperty("quantity") final int quantity, @JsonProperty("picture") final String picture, @JsonProperty("description") final String description, @JsonProperty("categoryId") final int categoryId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.picture = picture;
        this.description = description;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequest that = (ProductRequest) o;
        return Double.compare(that.price, price) == 0 && quantity == that.quantity && Objects.equals(name, that.name) && Objects.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity, picture);
    }
}
