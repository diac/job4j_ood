package ru.job4j.parking;

public class PassengerCar implements Car {

    private static final int SIZE = 1;

    @Override
    public int getSize() {
        return SIZE;
    }
}
