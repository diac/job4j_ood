package ru.job4j.isp.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static ru.job4j.isp.menu.SimpleMenuTest.STUB_ACTION;

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
        String expected = String.join(System.lineSeparator(),
                "1.Сходить в магазин",
                "----1.1.Купить продукты",
                "--------1.1.1.Купить хлеб",
                "--------1.1.2.Купить молоко",
                "2.Покормить собаку",
                "3.Зайти в УК",
                "----3.1.Внести квартплату",
                "----3.2.Вызвать электрика",
                "4.Починить сушилку" + System.lineSeparator()
        );
        MenuPrinter menuPrinter = new SimpleMenuPrinter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        menuPrinter.print(menu);
        Assertions.assertEquals(expected, out.toString());
    }
}