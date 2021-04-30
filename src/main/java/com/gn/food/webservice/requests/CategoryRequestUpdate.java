package com.gn.food.webservice.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gn.food.dao.models.Variant;

import java.util.List;
import java.util.Objects;

public class CategoryRequestUpdate {
    private final String name;
    private final List<Variant> variants;

    @JsonCreator
    public CategoryRequestUpdate(@JsonProperty("name") final String name, @JsonProperty("variants") final List<Variant> variants) {
        this.name = name;
        this.variants = variants;
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
        CategoryRequestUpdate that = (CategoryRequestUpdate) o;
        return Objects.equals(name, that.name) && Objects.equals(variants, that.variants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, variants);
    }
}
