package ru.job4j.employee;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.employee.ReportConstants.DATE_FORMAT;
import static ru.job4j.employee.ReportConstants.DECIMAL_FORMAT;

class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenNewGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee ivan = new Employee("Ivan", now, now, 100);
        Employee stepan = new Employee("Stepan", now, now, 200);
        store.add(ivan);
        store.add(stepan);
        Report engine = new BetterReportEngine(store);
        StringBuilder expect = new StringBuilder();
        expect.append("""
                <html>
                <head></head>
                <body>
                    <table>""");
        expect.append("""
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Salary</th>
                            </tr>
                        </thead>
                        <tbody>""")
                .append(System.lineSeparator());
        expect.append("<tr>");
        expect.append("<td>").append(stepan.getName()).append("</td>");
        expect.append("<td>").append("$" + DECIMAL_FORMAT.format(stepan.getSalary())).append("</td>");
        expect.append("</tr>");
        expect.append("<tr>");
        expect.append("<td>").append(ivan.getName()).append("</td>");
        expect.append("<td>").append("$" + DECIMAL_FORMAT.format(ivan.getSalary())).append("</td>");
        expect.append("</tr>");
        expect.append("""
                        </tbody>
                    </table>
                </body>
                </html>
                """);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}