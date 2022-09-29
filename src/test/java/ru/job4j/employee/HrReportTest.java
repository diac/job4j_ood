package ru.job4j.employee;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class HrReportTest {

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    @Test
    public void whenGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee ivan = new Employee("Ivan", now, now, 100);
        Employee stepan = new Employee("Stepan", now, now, 200);
        store.add(ivan);
        store.add(stepan);
        Report engine = new HrReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(stepan.getName()).append(";")
                .append("$" + DECIMAL_FORMAT.format(stepan.getSalary())).append(";")
                .append(System.lineSeparator())
                .append(ivan.getName()).append(";")
                .append("$" + DECIMAL_FORMAT.format(ivan.getSalary())).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}