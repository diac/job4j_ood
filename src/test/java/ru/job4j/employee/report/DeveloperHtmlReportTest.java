package ru.job4j.employee.report;

import org.junit.jupiter.api.Test;
import ru.job4j.employee.model.Employee;
import ru.job4j.employee.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.employee.report.ReportConstants.DATE_FORMAT;
import static ru.job4j.employee.report.ReportConstants.LINE_SEPARATOR;

class DeveloperHtmlReportTest {

    @Test
    public void whenGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee ivan = new Employee("Ivan", now, now, 100);
        Employee stepan = new Employee("Stepan", now, now, 200);
        store.add(ivan);
        store.add(stepan);
        Report engine = new DeveloperHtmlReport(store);
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
                                <th>Hired</th>
                                <th>Fired</th>
                                <th>Salary</th>
                            </tr>
                        </thead>
                        <tbody>""")
                .append(LINE_SEPARATOR);
        expect.append("<tr>");
        expect.append("<td>").append(ivan.getName()).append("</td>");
        expect.append("<td>").append(DATE_FORMAT.format(ivan.getHired().getTime())).append("</td>");
        expect.append("<td>").append(DATE_FORMAT.format(ivan.getFired().getTime())).append("</td>");
        expect.append("<td>").append(ivan.getSalary()).append("</td>");
        expect.append("</tr>");
        expect.append("<tr>");
        expect.append("<td>").append(stepan.getName()).append("</td>");
        expect.append("<td>").append(DATE_FORMAT.format(stepan.getHired().getTime())).append("</td>");
        expect.append("<td>").append(DATE_FORMAT.format(stepan.getFired().getTime())).append("</td>");
        expect.append("<td>").append(stepan.getSalary()).append("</td>");
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