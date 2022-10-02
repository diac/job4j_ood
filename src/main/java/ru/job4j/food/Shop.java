package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (accept(food)) {
            applyDiscount(food);
            result = foods.add(food);
        }
        return result;
    }

    @Override
    public boolean accept(Food food) {
        return getFoodExpiryRate(food) >= FoodExpiryThresholds.FRESH
                && getFoodExpiryRate(food) < FoodExpiryThresholds.SPOILED;
    }

    @Override
    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    private void applyDiscount(Food food) {
        if (getFoodExpiryRate(food) >= FoodExpiryThresholds.DISCOUNT) {
            food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount() / 100);
        }
    }

    @Override
    public List<Food> getExpired() {
        List<Food> expired = foods.stream()
                .filter(food -> getFoodExpiryRate(food) == FoodExpiryThresholds.SPOILED)
                .toList();
        foods.removeAll(expired);
        return expired;
    }

    @Override
    public void clear() {
        foods.clear();
    }
}
