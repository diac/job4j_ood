package ru.job4j.employee;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

class XmlReportTest {

    @Test
    public void whenGenerate() {
        Store store = new MemStore();
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            Calendar now = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            now.setTime(Date.from(LocalDate.parse("2022-09-30").atStartOfDay().toInstant(ZoneOffset.UTC)));
            store.add(new Employee("John Smith", now, now, 3200));
            store.add(new Employee("James Miller", now, now, 3700));
            Report report = new XmlReport(store, context, marshaller);
            var generated = report.generate(employee -> true);
            var expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" "
                    + "standalone=\"yes\"?><employees><employee><fired>2022-09-30T03:00:00+03:00</fired><hired>2022"
                    + "-09-30T03:00:00+03:00</hired><name>James Miller</name><salary>3700"
                    + ".0</salary></employee><employee><fired>2022-09-30T03:00:00+03:00</fired><hired>2022-09-30T03"
                    + ":00:00+03:00</hired><name>John Smith</name><salary>3200.0</salary></employee></employees>";
            assertThat(expected).isEqualTo(generated);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}