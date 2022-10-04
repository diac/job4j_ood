package ru.job4j.isp.menu;

import java.util.Scanner;

public class TODOApp {

    private static final int ADD_TODO_CHOICE = 1;
    private static final int LIST_TODOS_CHOICE = 2;
    private static final String CHOOSE_ACTION = "Выберите действие:";
    private static final String ADD_TODO = ADD_TODO_CHOICE + ". Добавить задачу";
    private static final String LIST_TODOS = LIST_TODOS_CHOICE + ". Вывести список задач";
    private static final String QUIT = "3. Завершить работу";
    private static final String ENTER_TODO_NAME = "Введите название задачи";
    private static final String ENTER_PARENT_TODO_NAME = "Введите название родительской задачи (оставьте пустым для добавления в корень)";
    private static final String TODO_CREATED = "Задача добавлена";
    private static final String QUITTING = "Завершение работы";

    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new SimpleMenuPrinter();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(CHOOSE_ACTION);
            System.out.println(ADD_TODO);
            System.out.println(LIST_TODOS);
            System.out.println(QUIT);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == ADD_TODO_CHOICE) {
                System.out.println(ENTER_TODO_NAME);
                String taskName = scanner.nextLine();
                System.out.println(ENTER_PARENT_TODO_NAME);
                String parentTaskName = scanner.nextLine();
                if (parentTaskName.isBlank()) {
                    parentTaskName = null;
                }
                menu.add(parentTaskName, taskName, STUB_ACTION);
                System.out.println(TODO_CREATED);
                menuPrinter.print(menu);
            } else if (choice == LIST_TODOS_CHOICE) {
                menuPrinter.print(menu);
            } else {
                run = false;
            }
        }
        System.out.println(QUITTING);
    }
}
