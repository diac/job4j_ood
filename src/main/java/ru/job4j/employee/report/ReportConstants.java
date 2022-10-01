package ru.job4j.employee.report;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ReportConstants {

    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
}
