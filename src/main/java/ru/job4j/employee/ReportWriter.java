package ru.job4j.employee;

public interface ReportWriter {

    void setDataType(String dataType);

    void write(String reportContent);
}
