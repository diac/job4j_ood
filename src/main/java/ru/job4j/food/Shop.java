package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        boolean canAccept = getFoodExpiryRate(food) >= FoodExpiryThresholds.FRESH
                && getFoodExpiryRate(food) < FoodExpiryThresholds.SPOILED;
        if (canAccept) {
            applyDiscount(food);
            foods.add(food);
        }
        return canAccept;
    }

    @Override
    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    @Override
    public List<Food> getExpired() {
        List<Food> expired = foods.stream()
                .filter(food -> getFoodExpiryRate(food) == FoodExpiryThresholds.SPOILED)
                .toList();
        foods.removeAll(expired);
        return expired;
    }
}
