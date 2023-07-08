package com.example.coffeehouse.controllers;

import com.example.coffeehouse.model.Coffee;
import com.example.coffeehouse.model.CoffeeOrder;
import com.example.coffeehouse.model.Ingredient;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@SessionAttributes("coffeeOrder")
@RequestMapping("/design")
public class DesignCoffeeController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("МОЛ_КОР", "Коровье Молоко", Ingredient.Type.MILK),
                new Ingredient("МОЛ_КОК", "Кокосовое Молоко", Ingredient.Type.MILK),
                new Ingredient("СИР_КЛЕН", "Кленовый Сироп", Ingredient.Type.SYRUP),
                new Ingredient("СИР_БАН", "Банановый Сироп", Ingredient.Type.SYRUP),
                new Ingredient("ДОП_КОР", "Корица", Ingredient.Type.ADDITIONAL),
                new Ingredient("ТИП_ЛАТ", "Латте", Ingredient.Type.COFFEE),
                new Ingredient("ТИП_КАП", "Капучино", Ingredient.Type.COFFEE),
                new Ingredient("ТИП_ФЛЭТ", "Флэт Уайт", Ingredient.Type.COFFEE)
        );
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

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
