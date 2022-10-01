package ru.job4j.employee.report;

import ru.job4j.employee.model.Employee;

import java.util.function.Predicate;

public interface Report {

    String outputType();

    String generate(Predicate<Employee> filter);
}
