package ru.job4j.employee;

import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class JsonReportTest {

    @Test
    public void whenGenerate() {
        Store store = new MemStore();
        var gson = new GsonBuilder().create();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        now.setTime(Date.from(LocalDate.parse("2022-09-30").atStartOfDay().toInstant(ZoneOffset.UTC)));
        store.add(new Employee("John Smith", now, now, 3200));
        store.add(new Employee("James Miller", now, now, 3700));
        Report report = new JsonReport(store, gson);
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