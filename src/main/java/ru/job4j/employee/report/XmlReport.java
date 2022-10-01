package ru.job4j.employee.report;

import ru.job4j.employee.model.Employee;
import ru.job4j.employee.model.Employees;
import ru.job4j.employee.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XmlReport implements Report {

    private final Store store;
    private final Marshaller marshaller;

    public XmlReport(Store store) throws JAXBException {
        this.store = store;
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        this.marshaller = context.createMarshaller();
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
