package com.aornelas.burger_app.domain;

import lombok.Data;

@Data
public class Burger {
    private Long id;
    private String name;
    private Double price;
    private String description;
}