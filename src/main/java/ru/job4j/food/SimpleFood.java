package ru.job4j.food;

import java.util.Calendar;

public class SimpleFood extends Food {

    public SimpleFood(String name, Calendar expiryDate, Calendar createDate, float price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
