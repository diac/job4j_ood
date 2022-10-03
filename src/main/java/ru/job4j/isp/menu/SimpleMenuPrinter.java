package ru.job4j.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    public static final String TAB = "----";

    @Override
    public void print(Menu menu) {
        for (var item : menu) {
            int depth = item.getNumber().split("\\.").length - 1;
            System.out.println(TAB.repeat(depth) + item.getNumber() + item.getName());
        }
    }
}
