package ru.job4j.food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Trash implements Store {

    List<Food> foods = new ArrayList<>();

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
        return null;
    }
}
