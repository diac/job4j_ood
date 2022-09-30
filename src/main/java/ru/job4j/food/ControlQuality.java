package ru.job4j.food;

import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void sort(List<Food> foods) {
        for (var food : foods) {
            for (var store : stores) {
                if (store.add(food)) {
                    break;
                }
            }
        }
    }
}
