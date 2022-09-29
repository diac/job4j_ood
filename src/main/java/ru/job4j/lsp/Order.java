package ru.job4j.lsp;

public abstract class Order {

    protected double subtotal;
    protected float taxRate;

    public double calculateTotal() {
        return subtotal + subtotal * taxRate;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        if (taxRate < 0) {
            throw new IllegalArgumentException("Налоговая ставка не может быть отрицательной");
        }
        this.taxRate = taxRate;
    }
}
