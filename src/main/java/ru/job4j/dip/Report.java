package ru.job4j.dip;

public class Report {

    /* Нарушение DIP -- тип принимаемого параметра является конкретной реализацией
     * */
    public void print(InvoiceStore store) {
        /* Нарушение DIP -- в методе явным образом используется конкретная реализация System.out
        * */
        store.getInvoices().forEach(System.out::println);
    }

    /* Нарушение DIP -- тип принимаемого параметра является конкретной реализацией
     * */
    public void printDue(InvoiceStore store) {
        /* Нарушение DIP -- в методе явным образом используется конкретная реализация System.out
         * */
        store.getDueInvoices().forEach(System.out::println);
    }
}
