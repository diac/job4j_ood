package ru.job4j.food;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    public void whenAddAllToWarehouse() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        Calendar today = Calendar.getInstance();
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 10);
        List<Food> foods = List.of(
                new SimpleFood("Pork", future, today, 150, 5),
                new SimpleFood("Beef", future, today, 120, 5),
                new SimpleFood("Mutton", future, today, 200, 5)
        );
        controlQuality.sort(foods);
        assertThat(warehouse.getFoods().containsAll(foods)).isTrue();
        assertThat(shop.getFoods()).isEmpty();
        assertThat(trash.getFoods()).isEmpty();
    }

    @Test
    public void whenAddAllToShop() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        List<Food> foods = List.of(
                new SimpleFood("Pork", tomorrow, yesterday, 150, 5),
                new SimpleFood("Beef", tomorrow, yesterday, 120, 5),
                new SimpleFood("Mutton", tomorrow, yesterday, 200, 5)
        );
        controlQuality.sort(foods);
        assertThat(warehouse.getFoods()).isEmpty();
        assertThat(shop.getFoods().containsAll(foods)).isTrue();
        assertThat(trash.getFoods()).isEmpty();
    }

    @Test
    public void whenAddAllToTrash() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DATE, -10);
        List<Food> foods = List.of(
                new SimpleFood("Pork", yesterday, past, 150, 5),
                new SimpleFood("Beef", yesterday, past, 120, 5),
                new SimpleFood("Mutton", yesterday, past, 200, 5)
        );
        controlQuality.sort(foods);
        assertThat(warehouse.getFoods()).isEmpty();
        assertThat(shop.getFoods()).isEmpty();
        assertThat(trash.getFoods().containsAll(foods)).isTrue();
    }

    @Test
    public void whenSortAllSeparately() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        Calendar today = Calendar.getInstance();
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 10);
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DATE, -10);
        Food fresh = new SimpleFood("Fresh", future, today, 100, 0);
        Food good = new SimpleFood("Good", tomorrow, yesterday, 100, 0);
        Food spoiled = new SimpleFood("Spoiled", yesterday, past, 100, 0);
        List<Food> foods = List.of(fresh, good, spoiled);
        controlQuality.sort(foods);
        assertThat(warehouse.getFoods()).containsExactly(fresh);
        assertThat(shop.getFoods()).containsExactly(good);
        assertThat(trash.getFoods()).contains(spoiled);
    }

    @Test
    public void whenAddToShopApplyDiscount() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DATE, -5);
        List<Food> foods = List.of(new SimpleFood("Food", tomorrow, past, 100, 25));
        controlQuality.sort(foods);
        assertThat(shop.getFoods().containsAll(foods)).isTrue();
        assertThat(foods.get(0).getPrice()).isEqualTo(75);
    }
}