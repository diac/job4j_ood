package ru.job4j.lsp;

/*
Данная реализация нарушает LSP потому что контекст выполнения задачи зависит от конкретных реализаций
VirtualProduct и RealProduct, вместо того, чтобы зависеть от абстракции Product.
Интерфейс Product в такой реализации практически не выполняет свое назначение выступать в качестве контракта,
так как в данном примере ключевым фактором выступает имя конкретного класса, а не его абстракции.
Здесь предполагается, что процедура выполнения заказа для VirtualProduct и RealProduct сильно отличается.
 */
public class Shop {

    public static void main(String[] args) {
        Product product = placeOrder();
        if (product instanceof VirtualProduct) {
            System.out.println("Ваша ссылка для скачивания: <a href=\"#\">Скачать</a>");
        } else if (product instanceof RealProduct) {
            System.out.println("Заказ принят и будет доставлен втечение 3 рабочих дней.");
        }
    }

    private static Product placeOrder() {
        return null;
    }
}
