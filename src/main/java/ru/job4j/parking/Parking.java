package ru.job4j.parking;

import java.util.List;

public interface Parking {

    void park(Car car);

    void remove(Car car);

    int getAvailablePassengerCarPlaces();

    int getAvailableTruckPlaces();

    List<Car> getCars();
}
