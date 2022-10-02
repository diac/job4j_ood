package ru.job4j.dip;

import java.util.Objects;

public class InvoiceItem {

    private String name;
    private String units;
    private String quantity;
    private int price;

    /* Нарушение DIP -- поле объявлено через конкретную реализацию */
    private Invoice invoice;

    public InvoiceItem() {
    }

    public InvoiceItem(String name, String units, String quantity, int price, Invoice invoice) {
        this.name = name;
        this.units = units;
        this.quantity = quantity;
        this.price = price;
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InvoiceItem that = (InvoiceItem) o;
        return price == that.price && name.equals(that.name) && units.equals(that.units)
                && quantity.equals(that.quantity)
                && invoice.equals(that.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units, quantity, price, invoice);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InvoiceItem{");
        sb.append("name='").append(name).append('\'');
        sb.append(", units='").append(units).append('\'');
        sb.append(", quantity='").append(quantity).append('\'');
        sb.append(", price=").append(price);
        sb.append(", invoice=").append(invoice);
        sb.append('}');
        return sb.toString();
    }
}
