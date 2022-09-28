package ru.job4j.employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileReportWriter implements ReportWriter {

    private String dataType;

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public void write(String reportContent) {
        String outputFilePath = "./employees";
        if ("json".equals(dataType)) {
            outputFilePath += ".json";
        } else if ("xml".equals(dataType)) {
            outputFilePath += ".xml";
        }
        File file = new File(outputFilePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(reportContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
