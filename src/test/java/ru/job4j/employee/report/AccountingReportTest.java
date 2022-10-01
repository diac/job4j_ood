package ru.job4j.employee.report;

import org.junit.jupiter.api.Test;
import ru.job4j.employee.model.Employee;
import ru.job4j.employee.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.employee.report.ReportConstants.*;

class AccountingReportTest {

    @Test
    public void whenGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new AccountingReport(store);
        String expect = "Name; Hired; Fired; Salary;" + LINE_SEPARATOR + worker.getName() + ";"
                + DATE_FORMAT.format(worker.getHired().getTime()) + ";"
                + DATE_FORMAT.format(worker.getFired().getTime()) + ";" + "$"
                + DECIMAL_FORMAT.format(worker.getSalary()) + ";" + LINE_SEPARATOR;
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}