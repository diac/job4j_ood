package ru.job4j.employee;

import java.util.Comparator;
import java.util.function.Predicate;

import static ru.job4j.employee.Constants.LINE_SEPARATOR;

public class HrReport implements Report {

    private Store store;

    public HrReport(Store store) {
        this.store = store;
    }

    @Override
    public String outputType() {
        return "raw";
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(LINE_SEPARATOR);
        for (Employee employee
                : store.findBy(filter).stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList()
        ) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(LINE_SEPARATOR);
        }
        return text.toString();
    }
}
