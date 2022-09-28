package ru.job4j.employee;

public class ConsoleReportWriter implements ReportWriter {

    @Override
    public void setDataType(String dataType) {

    }

    @Override
    public void write(String reportContent) {
        System.out.println(reportContent);
    }
}
