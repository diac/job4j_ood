package ru.job4j.food;

import java.util.*;

public class Warehouse implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        boolean canAccept = getFoodExpiryRate(food) < FoodExpiryThresholds.FRESH;
        if (canAccept) {
            foods.add(food);
        }
        return canAccept;
    }

    @Override
    public boolean addAll(Collection<Food> foods) {
        return this.foods.addAll(foods);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public List<Food> getExpired() {
        List<Food> expired = foods.stream()
                .filter(food -> getFoodExpiryRate(food) >= FoodExpiryThresholds.FRESH)
                .toList();
        foods.removeAll(expired);
        return expired;
    }
}
