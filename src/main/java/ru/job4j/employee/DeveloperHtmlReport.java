package ru.job4j.employee;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class DeveloperHtmlReport implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

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
                .append(System.lineSeparator());
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
