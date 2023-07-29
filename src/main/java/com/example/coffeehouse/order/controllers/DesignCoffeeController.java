package com.example.coffeehouse.order.controllers;

import com.example.coffeehouse.order.data.repositories.IngredientRepository;
import com.example.coffeehouse.order.model.Coffee;
import com.example.coffeehouse.order.model.CoffeeOrder;
import com.example.coffeehouse.order.model.Ingredient;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes("coffeeOrder")
@RequestMapping("/design")
public class DesignCoffeeController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignCoffeeController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @ModelAttribute(name = "coffeeOrder")
    public CoffeeOrder order() {
        return new CoffeeOrder();
    }

    @ModelAttribute("coffeeObj")
    public Coffee coffee(){
       return new Coffee();
    }


    @PostMapping
    public String processCoffee(@ModelAttribute("coffeeObj") @Valid Coffee coffeeObj, Errors errors, @ModelAttribute CoffeeOrder coffeeOrder){
        if(errors.hasErrors()) {
            return "design";
        }
        coffeeOrder.addCoffee(coffeeObj);
        log.info("Processing coffeeObj: {}", coffeeObj);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(Iterable<Ingredient> ingredients, Ingredient.Type type){
        Iterator<Ingredient> ingredientIterator = ingredients.iterator();
        List<Ingredient> ingredientFilter = new ArrayList<>();
        while(ingredientIterator.hasNext()){
            Ingredient ingredient = ingredientIterator.next();
            if(ingredient.getType().equals(type)) {
                ingredientFilter.add(ingredient);
            }
        }

        return ingredientFilter;
    }
}
