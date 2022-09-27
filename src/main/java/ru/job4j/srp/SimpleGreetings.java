package ru.job4j.srp;

import java.util.Scanner;

/**
 * В данной реализации нарушается SRP, т.к. класс одновременно отвечает за три непересекающихся действия:
 * - Генерация строки по шаблону
 * - Ввод из консоли
 * - Вывод в консоль
 */
public class SimpleGreetings implements Greetings {

    public void greetDialogue() {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        while (run) {
            String name = scanner.nextLine();
            if ("exit".equals(name)) {
                run = false;
            } else {
                greet(name);
            }
        }
    }

    @Override
    public void greet(String name) {
        System.out.println(formattedGreeting(name));
    }

    @Override
    public String formattedGreeting(String name) {
        return String.format("Hello %s!", name);
    }
}
