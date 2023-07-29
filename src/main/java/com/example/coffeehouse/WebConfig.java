package com.example.coffeehouse;

import com.example.coffeehouse.order.data.CoffeeRepository;
import com.example.coffeehouse.order.data.repositories.IngredientRepository;
import com.example.coffeehouse.order.model.Coffee;
import com.example.coffeehouse.order.model.Ingredient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepo,
                                        CoffeeRepository coffeeRepo){
        return args -> {
            Ingredient coconutMilk = new Ingredient("КОК_МОЛ", "Кокосовое молоко", Ingredient.Type.MILK);
            Ingredient flatWhite = new Ingredient("ФЛЭТ", "Флэт Уайт", Ingredient.Type.COFFEE);
            Ingredient coconutSyrop = new Ingredient("КОК_СИР", "Кокосовый сироп", Ingredient.Type.SYRUP);

            Ingredient bananaMilk = new Ingredient("БАН_МОЛ", "Банановое молоко", Ingredient.Type.MILK);
            Ingredient latte = new Ingredient("ЛАТТЕ", "Латте", Ingredient.Type.COFFEE);
            Ingredient caramelSyrup = new Ingredient("КАР_СИР", "Карамельный сироп", Ingredient.Type.SYRUP);

            ingredientRepo.save(coconutMilk);
            ingredientRepo.save(flatWhite);
            ingredientRepo.save(coconutSyrop);
            ingredientRepo.save(bananaMilk);
            ingredientRepo.save(latte);
            ingredientRepo.save(caramelSyrup);

            Coffee coffee1 = new Coffee();
            coffee1.setName("Кокосовый Флэт");
            coffee1.setIngredients(Arrays.asList(coconutMilk, flatWhite, coconutSyrop));
            coffeeRepo.save(coffee1);

            Coffee coffee2 = new Coffee();
            coffee2.setName("Бананово-карамельный Латте");
            coffee2.setIngredients(Arrays.asList(bananaMilk, latte, caramelSyrup));
            coffeeRepo.save(coffee2);
        };
    }
}
