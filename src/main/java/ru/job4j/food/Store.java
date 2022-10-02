package ru.job4j.food;

import java.util.Calendar;
import java.util.List;

public interface Store {

    boolean add(Food food);

    boolean accept(Food food);

    List<Food> getFoods();

    List<Food> getExpired();

    void clear();

    default long getFoodExpiryRate(Food food) {
        long expiryRate = (Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis())
                * 100
                / (food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis());
        return expiryRate <= 100 ? expiryRate : 100;
    }
}
