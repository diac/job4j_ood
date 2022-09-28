package ru.job4j.food;

import java.util.List;

public class ControlQuality {

    private final Store warehouse;
    private final Store shop;
    private final Store trash;

    public ControlQuality(Store warehouse, Store shop, Store trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void sort(List<Food> foods) {
        warehouse.addAll(foods);
        shop.addAll(warehouse.getExpired());
        trash.addAll(shop.getExpired());
    }
}
