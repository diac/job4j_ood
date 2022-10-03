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
        String expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;").append(LINE_SEPARATOR).append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append("$").append(DECIMAL_FORMAT.format(worker.getSalary())).append(";").append(LINE_SEPARATOR)
                .toString();
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}