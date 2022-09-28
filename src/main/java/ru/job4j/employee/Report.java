package ru.job4j.employee;

import java.util.function.Predicate;

public interface Report {

    String outputType();

    String generate(Predicate<Employee> filter);
}
