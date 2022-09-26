package ru.job4j.kiss;

import java.util.*;

public class MaxMin {

    private <T> List<T> maxMin(List<T> value, Comparator<T> comparator) {
        List<T> result = Arrays.asList(null, null);
        if (value.size() >= 2) {
            result.set(0, value.get(0));
            result.set(1, value.get(value.size() - 1));
            for (var item : value) {
                if (Objects.compare(result.get(0), item, comparator) > 0) {
                    result.set(0, item);
                }
                if (Objects.compare(result.get(1), item, comparator) <= 0) {
                    result.set(1, item);
                }
            }
        } else if (value.size() == 1) {
            result = Arrays.asList(value.get(0), value.get(0));
        }
        return result;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return maxMin(value, comparator).get(1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return maxMin(value, comparator).get(0);
    }
}
