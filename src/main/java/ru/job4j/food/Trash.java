package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        boolean canAccept = getFoodExpiryRate(food) >= FoodExpiryThresholds.SPOILED;
        if (canAccept) {
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
        return null;
    }
}
