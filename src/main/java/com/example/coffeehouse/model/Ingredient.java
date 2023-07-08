package com.example.coffeehouse.model;

import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class Ingredient {
    private String id;
    private String name;
    private Type type;

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Ingredient(){

    }

    protected boolean canEqual(final Object other) {
        return other instanceof Ingredient;
    }

    public enum Type {
        MILK, SYRUP, ADDITIONAL, COFFEE
    }
}
