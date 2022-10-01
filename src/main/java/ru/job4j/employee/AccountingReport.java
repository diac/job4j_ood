package ru.job4j.employee;

import java.util.function.Predicate;

import static ru.job4j.employee.ReportConstants.*;

public class AccountingReport implements Report {

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
                .append(LINE_SEPARATOR);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append("$" + DECIMAL_FORMAT.format(employee.getSalary())).append(";")
                    .append(LINE_SEPARATOR);
        }
        return text.toString();
    }
}
