package ru.job4j.parking;

import java.util.ArrayList;
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
        if (passengerCars.contains(car) || trucks.contains(car)) {
            return false;
        }
        boolean success = false;
        if (car.getSize() > PassengerCar.SIZE) {
            success = parkTruck(car);
        } else {
            success = parkPassengerCar(car);
        }
        return success;
    }

    @Override
    public boolean remove(Car car) {
        boolean success = false;
        if (trucks.contains(car)) {
            success = trucks.remove(car);
        } else if (passengerCars.contains(car)) {
            success = passengerCars.remove(car);
        }
        return success;
    }

    @Override
    public int getCarPlaces() {
        return carPlaces;
    }

    @Override
    public int getTruckPlaces() {
        return truckPlaces;
    }

    @Override
    public List<Car> getCars() {
        List<Car> result = new ArrayList<>(trucks);
        result.addAll(passengerCars);
        return result;
    }

    private boolean parkTruck(Car car) {
        boolean success = false;
        if (trucks.size() < truckPlaces) {
            success = trucks.add(car);
        } else if (passengerCars.size() + car.getSize() <= carPlaces) {
            success = passengerCars.add(car);
        }
        return success;
    }

    private boolean parkPassengerCar(Car car) {
        boolean success = false;
        if (passengerCars.size() < carPlaces) {
            success = passengerCars.add(car);
        }
        return success;
    }
}
