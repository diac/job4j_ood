package ru.job4j.employee.report;

import org.junit.jupiter.api.Test;
import ru.job4j.employee.model.Employee;
import ru.job4j.employee.store.MemStore;
import ru.job4j.employee.store.Store;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class XmlReportTest {

    @Test
    public void whenGenerate() {
        Store store = new MemStore();
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(Date.from(LocalDate.parse("2022-09-30").atStartOfDay().toInstant(ZoneOffset.UTC)));
            store.add(new Employee("John Smith", now, now, 3200));
            store.add(new Employee("James Miller", now, now, 3700));
            Report report = new XmlReport(store);
            var generated = report.generate(employee -> true);
            var expected = new StringBuilder()
                    .append("<?xml version=\"1.0\" encoding=\"UTF-8\" ")
                    .append("standalone=\"yes\"?><employees><employee><fired>2022-09-30T03:00:00+03:00</fired><hired>2022")
                    .append("-09-30T03:00:00+03:00</hired><name>James Miller</name><salary>3700")
                    .append(".0</salary></employee><employee><fired>2022-09-30T03:00:00+03:00</fired><hired>2022-09-30T03")
                    .append(":00:00+03:00</hired><name>John Smith</name><salary>3200.0</salary></employee></employees>")
                    .toString();
            assertThat(expected).isEqualTo(generated);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}