package ru.job4j.isp.menu;

import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new SimpleMenuPrinter();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("""
                    Выберите действие:
                    1. Добавить задачу
                    2. Вывести список задач
                    3. Завершить работу""");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Введите название задачи");
                String taskName = scanner.nextLine();
                System.out.println("Введите название родительской задачи (оставьте пустым для добавления в корень)");
                String parentTaskName = scanner.nextLine();
                if (parentTaskName.isBlank()) {
                    parentTaskName = null;
                }
                menu.add(parentTaskName, taskName, STUB_ACTION);
                System.out.println("Задача добавлена");
                menuPrinter.print(menu);
            } else if (choice == 2) {
                menuPrinter.print(menu);
            } else {
                run = false;
            }
        }
        System.out.println("Завершение работы");
    }
}
