package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MaxMinTest {

    private final MaxMin maxMin = new MaxMin();

    @Test
    public void whenMax() {
        List<Integer> list = List.of(2, 1, 3, 5, 4);
        assertThat(maxMin.min(list, Comparator.naturalOrder())).isEqualTo(1);
    }

    @Test
    public void whenMin() {
        List<Integer> list = List.of(2, 1, 3, 5, 4);
        assertThat(maxMin.max(list, Comparator.naturalOrder())).isEqualTo(5);
    }

    @Test
    public void whenEmptyThenMinIsNull() {
        List<Integer> list = new ArrayList<>();
        assertThat(maxMin.min(list, Comparator.naturalOrder())).isNull();
    }

    @Test
    public void whenEmptyThenMaxIsNull() {
        List<Integer> list = new ArrayList<>();
        assertThat(maxMin.max(list, Comparator.naturalOrder())).isNull();
    }

    @Test
    public void whenOneElementThenMaxEqualsMin() {
        List<Integer> list = List.of(555);
        assertThat(maxMin.min(list, Comparator.naturalOrder()))
                .isEqualTo(maxMin.max(list, Comparator.naturalOrder()))
                .isEqualTo(555);
    }
}