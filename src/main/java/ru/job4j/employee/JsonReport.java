package ru.job4j.employee;

import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class JsonReport implements Report {

    private final Store store;

    public JsonReport(Store store) {
        this.store = store;
    }

    @Override
    public String outputType() {
        return "json";
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = EmployeesReportData.standardReport(store, filter);
        var gsonBuilder = new GsonBuilder().create();
        return gsonBuilder.toJson(employees);
    }
}
