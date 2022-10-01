package ru.job4j.employee.report;

import ru.job4j.employee.model.Employee;
import ru.job4j.employee.model.Employees;
import ru.job4j.employee.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XmlReport implements Report {

    private final Store store;
    private final JAXBContext context;
    private final Marshaller marshaller;

    public XmlReport(Store store, JAXBContext context, Marshaller marshaller) {
        this.store = store;
        this.context = context;
        this.marshaller = marshaller;
    }

    @Override
    public String outputType() {
        return "xml";
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = EmployeesReportData.standardReport(store, filter);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employees(employees), writer);
            xml = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }
}
