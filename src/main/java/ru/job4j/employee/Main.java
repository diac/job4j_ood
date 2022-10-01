package ru.job4j.employee;

import ru.job4j.employee.model.Employee;
import ru.job4j.employee.store.MemStore;
import ru.job4j.employee.store.Store;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Store store = new MemStore();
        populateStore(store);
        UI ui = new UI(store);
        try {
            ui.run();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void populateStore(Store store) {
        Calendar now = Calendar.getInstance();
        List<Employee> employees = List.of(
                new Employee("John Smith", now, now, 3200),
                new Employee("James Miller", now, now, 3700),
                new Employee("Tim Wilson", now, now, 3100),
                new Employee("Jacek Zamachowski", now, now, 4100),
                new Employee("Astrid Bjornsdottir", now, now, 5300),
                new Employee("Sergey Smirnov", now, now, 3600),
                new Employee("Istvan Kovacs", now, now, 3400),
                new Employee("Marcello Giordano", now, now, 4200),
                new Employee("Dan Harris", now, now, 3100),
                new Employee("Patricia Martinez", now, now, 3700),
                new Employee("Bruno Lewenberg", now, now, 4400)
        );
        for (var employee : employees) {
            store.add(employee);
        }
    }
}
