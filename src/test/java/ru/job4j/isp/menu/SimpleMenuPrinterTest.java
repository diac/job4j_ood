package ru.job4j.isp.menu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

import static ru.job4j.isp.menu.SimpleMenuTest.*;

class SimpleMenuPrinterTest {

    @Test
    public void whenPrint() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        menu.add(Menu.ROOT, "Зайти в УК", STUB_ACTION);
        menu.add("Зайти в УК", "Внести квартплату", STUB_ACTION);
        menu.add("Зайти в УК", "Вызвать электрика", STUB_ACTION);
        menu.add(Menu.ROOT, "Починить сушилку", STUB_ACTION);
        String expected = new StringBuilder()
                .append("1.Сходить в магазин").append(System.lineSeparator())
                .append("----1.1.Купить продукты").append(System.lineSeparator())
                .append("--------1.1.1.Купить хлеб").append(System.lineSeparator())
                .append("--------1.1.2.Купить молоко").append(System.lineSeparator())
                .append("2.Покормить собаку").append(System.lineSeparator())
                .append("3.Зайти в УК").append(System.lineSeparator())
                .append("----3.1.Внести квартплату").append(System.lineSeparator())
                .append("----3.2.Вызвать электрика").append(System.lineSeparator())
                .append("4.Починить сушилку").append(System.lineSeparator())
                .toString();
        MenuPrinter menuPrinter = new SimpleMenuPrinter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        menuPrinter.print(menu);
        assertThat(out.toString()).isEqualTo(expected);
    }
}