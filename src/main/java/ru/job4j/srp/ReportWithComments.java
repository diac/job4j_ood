package ru.job4j.srp;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * В данной реализации SRP нарушается потому, что
 * - Класс одновременно отвечает за хранение пар объектов и генерацию значений пар -- строк
 * - Реализация метода add() жестко привязана к формату данных "dd-MM-yyyy". Изменить формат на другой
 *      в данной реализации невозможно
 */
public class ReportWithComments implements Report {

    private Map<Person, String> peopleWithComments = new HashMap<>();

    @Override
    public Person add(Person person) {
        String comment = "Дата регистрации: "
                + LocalTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        peopleWithComments.put(person, comment);
        return person;
    }

    @Override
    public Set<Person> generate() {
        return null;
    }
}
