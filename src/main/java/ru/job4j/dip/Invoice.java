package ru.job4j.dip;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Invoice {

    private String number;
    private Date invoiceDate;
    private Date paymentDueDate;

    /* Нарушение DIP -- поле объявлено через конкретные реализации HashSet и Item.
    * Эта ошибка потянет за собой по цепочке ошибки в геттерах и сеттерах этого класса, а также в методах
    * других классов, зависящих от Invoice */
    private HashSet<InvoiceItem> items = new HashSet<>();

    public Invoice() {
    }

    public Invoice(String number, Date invoiceDate, Date paymentDueDate) {
        this.number = number;
        this.invoiceDate = invoiceDate;
        this.paymentDueDate = paymentDueDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Invoice invoice = (Invoice) o;
        return number.equals(invoice.number) && invoiceDate.equals(invoice.invoiceDate)
                && paymentDueDate.equals(invoice.paymentDueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, invoiceDate, paymentDueDate);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Invoice{");
        sb.append("number='").append(number).append('\'');
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", paymentDueDate=").append(paymentDueDate);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
