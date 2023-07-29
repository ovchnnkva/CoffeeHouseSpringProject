package com.example.coffeehouse.order.data.repositories;

import com.example.coffeehouse.order.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
