package ru.job4j.isp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VeryLongInt implements Addable {

    private List<Long> value = new LinkedList<>();

    @Override
    public void add(Object o) {
        value.set(value.size() - 1, value.get(value.size() - 1) + (Long) o);
    }
}
