package com.example.coffeehouse.converters;

import com.example.coffeehouse.model.Ingredient;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingrediaentMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingrediaentMap.put("МОЛ_КОР",   new Ingredient("МОЛ_КОР", "Коровье Молоко", Ingredient.Type.MILK));
        ingrediaentMap.put("МОЛ_КОК", new Ingredient("МОЛ_КОК", "Кокосовое Молоко", Ingredient.Type.MILK));
        ingrediaentMap.put("СИР_КЛЕН",new Ingredient("СИР_КЛЕН", "Кленовый Сироп", Ingredient.Type.SYRUP));
        ingrediaentMap.put("СИР_БАН",new Ingredient("СИР_БАН", "Банановый Сироп", Ingredient.Type.SYRUP));
        ingrediaentMap.put("ДОП_КОР", new Ingredient("ДОП_КОР", "Корица", Ingredient.Type.ADDITIONAL));
        ingrediaentMap.put("ТИП_ЛАТ",new Ingredient("ТИП_ЛАТ", "Латте", Ingredient.Type.COFFEE));
        ingrediaentMap.put("ТИП_КАП",new Ingredient("ТИП_КАП", "Капучино", Ingredient.Type.COFFEE));
        ingrediaentMap.put("ТИП_ФЛЭТ",new Ingredient("ТИП_ФЛЭТ", "Флэт Уайт", Ingredient.Type.COFFEE));
    }
    @Override
    public Ingredient convert(String source) {
        return ingrediaentMap.get(source);
    }
}
