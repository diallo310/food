package com.gn.food.dao.models;

import javax.persistence.*;

@Entity
@Table(name = "Variants", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int variantId;
    private String name;
}
