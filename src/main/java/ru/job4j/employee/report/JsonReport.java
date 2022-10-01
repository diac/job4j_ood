package ru.job4j.employee.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.employee.model.Employee;
import ru.job4j.employee.store.Store;

import java.util.List;
import java.util.function.Predicate;

public class JsonReport implements Report {

    private final Store store;
    private final Gson gson;

    public JsonReport(Store store) {
        this.store = store;
        this.gson = new GsonBuilder().create();
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
