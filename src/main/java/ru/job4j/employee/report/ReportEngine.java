package ru.job4j.employee.report;

import ru.job4j.employee.model.Employee;
import ru.job4j.employee.store.Store;

import java.util.function.Predicate;

import static ru.job4j.employee.report.ReportConstants.DATE_FORMAT;
import static ru.job4j.employee.report.ReportConstants.LINE_SEPARATOR;

public class ReportEngine implements Report {

    private Store store;

    public ReportEngine(Store store) {
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
                    .append(employee.getSalary()).append(";")
                    .append(LINE_SEPARATOR);
        }
        return text.toString();
    }
}
