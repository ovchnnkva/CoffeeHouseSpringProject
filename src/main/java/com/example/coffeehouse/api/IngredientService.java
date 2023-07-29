package com.example.coffeehouse.api;


import com.example.coffeehouse.order.model.Ingredient;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {

  Iterable<Ingredient> findAll();
  
  Ingredient addIngredient(Ingredient ingredient);
    
}
