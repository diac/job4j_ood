package ru.job4j.parking;

import java.util.Objects;

public class PassengerCar implements Car {

    private static final int SIZE = 1;

    private final String name;

    public PassengerCar(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PassengerCar that = (PassengerCar) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
