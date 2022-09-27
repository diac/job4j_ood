package ru.job4j.srp.employee;

import java.util.function.Predicate;

public interface Report {

    String generate(Predicate<Employee> filter);
}
