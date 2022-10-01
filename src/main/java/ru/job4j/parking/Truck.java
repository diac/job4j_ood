package ru.job4j.parking;

import java.util.Objects;

public class Truck implements Car {

    private final int size;
    private final String name;

    public Truck(String name, int size) {
        if (size <= PassengerCar.SIZE) {
            throw new IllegalArgumentException(String.format("Размер грузовика не может быть меньше %d", PassengerCar.SIZE + 1));
        }
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return name.equals(truck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
