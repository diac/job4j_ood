package ru.job4j.employee;

import com.google.gson.Gson;

import java.util.List;
import java.util.function.Predicate;

public class JsonReport implements Report {

    private final Store store;
    private final Gson gson;

    public JsonReport(Store store, Gson gson) {
        this.store = store;
        this.gson = gson;
    }

    @Override
    public String outputType() {
        return "json";
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = EmployeesReportData.standardReport(store, filter);
        return gson.toJson(employees);
    }
}
