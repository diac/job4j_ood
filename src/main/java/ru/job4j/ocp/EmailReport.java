package ru.job4j.ocp;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Данная реализация нарушает OCP, так как возвращаемое методом generate() значение имеет строго указанный тип --
 * ArrayList<String>. Также поле archives привязано к конкретному типу -- LinkedList<EmailArchive>.
 * Оба этих обстоятельства делают невозможным расширение кода в его текущем состоянии.
 */
public class EmailReport {

    private LinkedList<EmailArchive> archives;

    public EmailReport(LinkedList<EmailArchive> archives) {
        this.archives = archives;
    }

    public ArrayList<String> generate() {
        ArrayList<String> compoundArchive = new ArrayList<>();
        for (var archive : archives) {
            compoundArchive.addAll(archive.getEmailAddresses());
        }
        return compoundArchive;
    }
}
