package ru.job4j.srp;

import java.util.HashSet;
import java.util.Set;

/**
 * В данной реализации нарушается SRP, т.к. в классе содерржится функциональность, отвечающая за
 * создание объектов другого класса -- Person, а также за валидацию полей при создании объектов.
 */
public class SimpleReport implements Report {

    private Set<Person> people = new HashSet<>();

    public Person newPerson(String firstName, String lastName, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        }
        return add(new Person(firstName, lastName, age));
    }

    @Override
    public Person add(Person person) {
        people.add(person);
        return person;
    }

    @Override
    public Set<Person> generate() {
        return people;
    }
}
