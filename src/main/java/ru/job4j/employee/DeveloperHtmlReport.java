package ru.job4j.employee;

import java.util.function.Predicate;

import static ru.job4j.employee.ReportConstants.DATE_FORMAT;
import static ru.job4j.employee.ReportConstants.LINE_SEPARATOR;

public class DeveloperHtmlReport implements Report {

    private final Store store;

    public DeveloperHtmlReport(Store store) {
        this.store = store;
    }

    @Override
    public String outputType() {
        return "html";
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("""
                <html>
                <head></head>
                <body>
                    <table>""");
        text.append("""
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
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr>");
            text.append("<td>").append(employee.getName()).append("</td>");
            text.append("<td>").append(DATE_FORMAT.format(employee.getHired().getTime())).append("</td>");
            text.append("<td>").append(DATE_FORMAT.format(employee.getFired().getTime())).append("</td>");
            text.append("<td>").append(employee.getSalary()).append("</td>");
            text.append("</tr>");
        }
        text.append("""
                        </tbody>
                    </table>
                </body>
                </html>
                """);
        return text.toString();
    }
}
