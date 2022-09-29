package ru.job4j.employee;

import java.text.DecimalFormat;
import java.util.function.Predicate;

public class HrReport implements Report {

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

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
                .append(System.lineSeparator());
        for (Employee employee
                : store.findBy(filter).stream()
                .sorted((left, right) -> left.getSalary() > right.getSalary() ? -1 : 1)
                .toList()
        ) {
            text.append(employee.getName()).append(";")
                    .append("$" + DECIMAL_FORMAT.format(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
