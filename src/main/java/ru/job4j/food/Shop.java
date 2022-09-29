package ru.job4j.food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Shop implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        boolean canAccept = getFoodExpiryRate(food) >= FoodExpiryThresholds.FRESH
                && getFoodExpiryRate(food) < FoodExpiryThresholds.SPOILED;
        if (canAccept) {
            foods.add(food);
        }
        return canAccept;
    }

    @Override
    public boolean addAll(Collection<Food> foods) {
        foods.forEach(this::applyDiscount);
        return this.foods.addAll(foods);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
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
