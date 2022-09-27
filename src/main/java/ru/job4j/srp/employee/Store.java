package ru.job4j.srp.employee;

import ru.job4j.srp.employee.Employee;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    void add(Employee em);

    List<Employee> findBy(Predicate<Employee> filter);
}
