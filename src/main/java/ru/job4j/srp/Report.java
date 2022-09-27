package ru.job4j.srp;

import java.util.Set;

public interface Report {

    Person add(Person person);

    Set<Person> generate();
}
