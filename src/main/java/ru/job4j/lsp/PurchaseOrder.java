package ru.job4j.lsp;

/*
В данной реализации переопределяется метод setTaxRate таким образом, что пропадает валидация данных из
абстрактного родительского класса. Соответственно поведение данного класса будет отличаться от
поведения родительского класса, в котором исключается ошибка отрицательной налоговой ставки.
Поскольку реализация, таким образом, не на 100% совместима со своей абстракцией, в данном примере нарушен LSP.
 */
public class PurchaseOrder extends Order {

    private double deliveryFee;

    @Override
    public double calculateTotal() {
        return this.subtotal + deliveryFee + (this.subtotal + deliveryFee) * taxRate;
    }

    @Override
    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }
}
