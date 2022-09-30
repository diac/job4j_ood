package ru.job4j.isp;

import java.util.LinkedList;
import java.util.List;

/*
* Класс предназначен для хранения очень больших целочисленных значений, выходящих за диапазон Long
* */
public class VeryLongInt implements Addable {

    private List<Long> value = new LinkedList<>();

    @Override
    public void add(Object o) {
        /* Приходится преобразовывать тип */
        value.set(value.size() - 1, value.get(value.size() - 1) + (Long) o);
    }
}
