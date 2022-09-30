package ru.job4j.parking;

public class PassengerCar implements Car {

    private static final int MAX_SIZE = 1;

    private final int size;

    public PassengerCar(int size) {
        if (size > MAX_SIZE) {
            throw new IllegalArgumentException(String.format("Размер легковой машины не может быть больше %d", MAX_SIZE));
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
