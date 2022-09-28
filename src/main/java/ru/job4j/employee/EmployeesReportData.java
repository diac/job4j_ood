package ru.job4j.employee;

import java.util.List;
import java.util.function.Predicate;

public class EmployeesReportData {

    public static List<Employee> standardReport(Store store, Predicate<Employee> filter) {
        return store.findBy(filter)
                .stream()
                .sorted((left, right) -> {
                    int result = 0;
                    if (left.getSalary() > right.getSalary()) {
                        result = -1;
                    } else if (left.getSalary() < right.getSalary()) {
                        result = 1;
                    }
                    return result;
                })
                .toList();
    }
}
