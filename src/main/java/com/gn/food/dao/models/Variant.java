package com.gn.food.dao.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Variants", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Variant {
    private int variantId;
    private String name;
}
