package ru.job4j.parking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleParking implements Parking {

    private Set<Car> passengerCars;
    private Set<Car> trucks;
    private final int carPlaces;
    private final int truckPlaces;

    public SimpleParking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
        passengerCars = new HashSet<>(carPlaces);
        trucks = new HashSet<>(truckPlaces);
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
