package ru.job4j.food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Shop implements Store {

    private static final byte EXPIRY_RATE_MAX = 100;
    private static final byte EXPIRY_RATE_DISCOUNT = 75;

    List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        applyDiscount(food);
        return foods.add(food);
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
                .filter(food -> food.expiryRate() == EXPIRY_RATE_MAX)
                .toList();
        foods.removeAll(expired);
        return expired;
    }

    private void applyDiscount(Food food) {
        if (food.getPrice() >= EXPIRY_RATE_DISCOUNT) {
            food.applyDiscount();
        }
    }
}
