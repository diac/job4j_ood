package ru.job4j.parking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleParking implements Parking {

    private Set<Car> passengerCars = new HashSet<>();
    private Set<Car> trucks = new HashSet<>();
    private final int availablePassengerCarPlaces;
    private final int availableTruckPlaces;

    public SimpleParking(int availablePassengerCarPlaces, int availableTruckPlaces) {
        this.availablePassengerCarPlaces = availablePassengerCarPlaces;
        this.availableTruckPlaces = availableTruckPlaces;
    }

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
