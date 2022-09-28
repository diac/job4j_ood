package ru.job4j.employee;

import java.text.DecimalFormat;
import java.util.function.Predicate;

public class BetterReportEngine implements Report {

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    private final Store store;

    public BetterReportEngine(Store store) {
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
                                <th>Salary</th>
                            </tr>
                        </thead>
                        <tbody>""")
                .append(System.lineSeparator());
        for (Employee employee
                : store.findBy(filter)
                    .stream()
                    .sorted((left, right) -> left.getSalary() > right.getSalary() ? -1 : 1)
                    .toList()
        ) {
            text.append("<tr>");
            text.append("<td>").append(employee.getName()).append("</td>");
            text.append("<td>").append("$" + DECIMAL_FORMAT.format(employee.getSalary())).append("</td>");
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
