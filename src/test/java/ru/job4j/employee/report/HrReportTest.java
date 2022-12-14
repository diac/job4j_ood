package ru.job4j.employee.report;

import org.junit.jupiter.api.Test;
import ru.job4j.employee.model.Employee;
import ru.job4j.employee.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.employee.report.ReportConstants.LINE_SEPARATOR;

class HrReportTest {

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
                .append(LINE_SEPARATOR)
                .append(stepan.getName()).append(";")
                .append(stepan.getSalary()).append(";")
                .append(LINE_SEPARATOR)
                .append(ivan.getName()).append(";")
                .append(ivan.getSalary()).append(";")
                .append(LINE_SEPARATOR);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}