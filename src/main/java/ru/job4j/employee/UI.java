package ru.job4j.employee;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Scanner;
import java.util.function.Predicate;

public class UI {

    private Report report;
    private ReportWriter reportWriter;
    private final Scanner scanner = new Scanner(System.in);

    private final Store store;

    private static final Predicate<Employee> FILTER = employee -> true;

    public UI(Store store) {
        this.store = store;
    }

    public void run() throws JAXBException {
        boolean run = true;
        var gson = new GsonBuilder().create();
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        while (run) {
            System.out.println("""
                    Выберите действие:
                    1: Сгенерировать отчет в формате JSON
                    2: Сгенерировать отчет в формате XML
                    Любой другой символ: Завершить работу""");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                report = new JsonReport(store, gson);
            } else if (choice == 2) {
                report = new XmlReport(store, context, marshaller);
            } else {
                run = false;
            }
            if (run) {
                System.out.println("""
                        Выберите действие:
                        1: Вывести результат в файл
                        2: Вывести результат в консоль
                        Любой другой символ: Завершить работу""");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    reportWriter = new FileReportWriter();
                } else if (choice == 2) {
                    reportWriter = new ConsoleReportWriter();
                } else {
                    run = false;
                }
                reportWriter.setDataType(report.outputType());
                reportWriter.write(report.generate(FILTER));
            }
        }
        System.out.println("Завершение работы");
    }
}
