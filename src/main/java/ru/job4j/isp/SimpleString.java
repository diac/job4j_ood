package ru.job4j.isp;

public class SimpleString implements Addable {

    private String value = "";

    @Override
    public void add(Object o) {
        /* Приходится преобразовывать тип */
        value += o.toString();
    }
}
