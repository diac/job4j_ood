package ru.job4j.employee;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class AccountingReport implements Report {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    private Store store;

    public AccountingReport(Store store) {
        this.store = store;
    }

    @Override
    public String outputType() {
        return "raw";
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append("$" + DECIMAL_FORMAT.format(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
