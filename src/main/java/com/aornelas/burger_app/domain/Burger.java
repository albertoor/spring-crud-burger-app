package com.aornelas.burger_app.domain;

import lombok.Data;

@Data
public class Burger {
    private Long id;
    private String name;
    private Double price;
    private String description;

    public Burger(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Burger(){}
}