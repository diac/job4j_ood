package ru.job4j.food;

import java.util.Collection;
import java.util.List;

public interface Store {

    boolean add(Food food);

    boolean addAll(Collection<Food> foods);

    List<Food> getFoods();

    List<Food> getExpired();
}
