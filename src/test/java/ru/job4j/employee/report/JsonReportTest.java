package ru.job4j.employee.report;

import org.junit.jupiter.api.Test;
import ru.job4j.employee.model.Employee;
import ru.job4j.employee.store.MemStore;
import ru.job4j.employee.store.Store;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class JsonReportTest {

    @Test
    public void whenGenerate() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        now.setTime(Date.from(LocalDate.parse("2022-09-30").atStartOfDay().toInstant(ZoneOffset.UTC)));
        store.add(new Employee("John Smith", now, now, 3200));
        store.add(new Employee("James Miller", now, now, 3700));
        Report report = new JsonReport(store);
        var generated = report.generate(employee -> true);
        var expected = "[{\"name\":\"James Miller\",\"hired\":{\"year\":2022,\"month\":8,\"dayOfMonth\":30,"
                + "\"hourOfDay\":3,\"minute\":0,\"second\":0},\"fired\":{\"year\":2022,\"month\":8,\"dayOfMonth\":30,"
                + "\"hourOfDay\":3,\"minute\":0,\"second\":0},\"salary\":3700.0},{\"name\":\"John Smith\","
                + "\"hired\":{\"year\":2022,\"month\":8,\"dayOfMonth\":30,\"hourOfDay\":3,\"minute\":0,\"second\":0},"
                + "\"fired\":{\"year\":2022,\"month\":8,\"dayOfMonth\":30,\"hourOfDay\":3,\"minute\":0,\"second\":0},"
                + "\"salary\":3200.0}]";
        assertThat(expected).isEqualTo(generated);
    }
}