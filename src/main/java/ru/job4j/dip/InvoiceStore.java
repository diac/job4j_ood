package ru.job4j.dip;

import java.util.Calendar;
import java.util.HashSet;
import java.util.stream.Collectors;

public class InvoiceStore {

    /* Нарушение DIP -- поле объявлено через конкретные реализации HashSet и Invoice.
     * Эта ошибка потянет за собой по цепочке ошибки в геттерах и сеттерах этого класса, а также в методах
     * других классов, зависящих от Invoice и InvoiceStore
     * */
    private HashSet<Invoice> invoices = new HashSet<>();

    /* Нарушение DIP -- тип принимаемого параметра является конкретной реализацией
    * */
    public boolean add(Invoice invoice) {
        return invoices.add(invoice);
    }

    /* Нарушение DIP -- тип принимаемого параметра является конкретной реализацией
    * */
    public boolean remove(Invoice invoice) {
        return invoices.remove(invoice);
    }

    /* Нарушение DIP -- тип возвращаемого значения зависит сразу от двух конкретных реализаций:
    *  HashSet и Invoice
    * */
    public HashSet<Invoice> getInvoices() {
        return invoices;
    }

    /* Нарушение DIP -- тип возвращаемого значения зависит сразу от двух конкретных реализаций:
     *  HashSet и Invoice
     * */
    public HashSet<Invoice> getDueInvoices() {
        /* Нарушение DIP -- из-за изначально неверной привязки к конкретным реализациям HashSet и Invoice
        * приходится приводить возвращаемую стримом коллекцию к HashSet<Invoice>
        */
        return (HashSet<Invoice>) invoices.stream()
                .filter(invoice -> {
                    var today = Calendar.getInstance();
                    today.set(Calendar.HOUR_OF_DAY, 0);
                    return invoice.getInvoiceDate().before(today.getTime());
                })
                .collect(Collectors.toSet());
    }
}
