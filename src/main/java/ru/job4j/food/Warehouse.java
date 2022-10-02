package ru.job4j.food;

import java.util.*;

public class Warehouse implements Store {

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
        return getFoodExpiryRate(food) < FoodExpiryThresholds.FRESH;
    }

    @Override
    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    @Override
    public List<Food> getExpired() {
        List<Food> expired = foods.stream()
                .filter(food -> getFoodExpiryRate(food) >= FoodExpiryThresholds.FRESH)
                .toList();
        foods.removeAll(expired);
        return expired;
    }

    @Override
    public void clear() {
        foods.clear();
    }
}
