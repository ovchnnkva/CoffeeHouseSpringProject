package com.example.coffeehouse.api;


import com.example.coffeehouse.order.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService extends CrudRepository<Ingredient, String> {
    
}
