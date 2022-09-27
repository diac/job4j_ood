package ru.job4j.kiss;

import java.util.*;
import java.util.function.BiPredicate;

public class MaxMin {

    private <T> T maxMin(List<T> value, BiPredicate<T, T> predicate) {
        T result = null;
        if (value.size() > 0) {
            result = value.get(0);
            for (var i = 1; i < value.size(); i++) {
                if (predicate.test(result, value.get(i))) {
                    result = value.get(i);
                }
            }
        }
        return result;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> predicate = (left, right) -> comparator.compare(left, right) <= 0;
        return maxMin(value, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> predicate = (left, right) -> comparator.compare(left, right) > 0;
        return maxMin(value, predicate);
    }
}
