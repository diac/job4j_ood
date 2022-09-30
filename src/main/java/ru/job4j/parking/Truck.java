package ru.job4j.parking;

public class Truck implements Car {

    private static final int MIN_SIZE = 2;

    private final int size;

    public Truck(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException(String.format("Размер грузовика не может быть меньше %d", MIN_SIZE));
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
