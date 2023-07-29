package com.example.coffeehouse.data.repositories;

import com.example.coffeehouse.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
