package com.example.coffeehouse.model;

import lombok.Data;

import java.util.List;

@Data
public class Coffee {
    private String name;
    private List<Ingredient> ingredients;
}
