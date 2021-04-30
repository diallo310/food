package com.gn.food.services.requests;

public class ProductRequest {
    private final String name;
    private final Double price;
    private final Integer quantity;
    private final String picture;

    public ProductRequest(final String name, final Double price, final Integer quantity, final String picture) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getPicture() {
        return picture;
    }
}
