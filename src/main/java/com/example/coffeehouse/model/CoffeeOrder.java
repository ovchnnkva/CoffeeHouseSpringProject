package com.example.coffeehouse.model;

import lombok.Data;

import java.util.List;

@Data
public class CoffeeOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZIp;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Coffee> coffeeList;

    public void addCoffee(Coffee coffee){
        this.coffeeList.add(coffee);
    }
}
