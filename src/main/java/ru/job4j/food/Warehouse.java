package ru.job4j.food;

import java.util.*;

public class Warehouse implements Store {

    private static final byte EXPIRY_RATE_THRESHOLD = 25;

    List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return foods.add(food);
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
                .filter(food -> food.expiryRate() >= EXPIRY_RATE_THRESHOLD)
                .toList();
        foods.removeAll(expired);
        return expired;
    }
}
