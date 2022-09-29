package ru.job4j.parking;

import java.util.List;

public class SimpleParking implements Parking {

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public int getAvailablePassengerCarPlaces() {
        return 0;
    }

    @Override
    public int getAvailableTruckPlaces() {
        return 0;
    }

    @Override
    public List<Car> getCars() {
        return null;
    }
}
