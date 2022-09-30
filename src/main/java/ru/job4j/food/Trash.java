package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (accept(food)) {
            result = foods.add(food);
        }
        return result;
    }

    @Override
    public boolean accept(Food food) {
        return getFoodExpiryRate(food) >= FoodExpiryThresholds.SPOILED;
    }

    @Override
    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    @Override
    public List<Food> getExpired() {
        return null;
    }
}
