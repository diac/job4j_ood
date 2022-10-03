package ru.job4j.parking;

import java.util.List;

public interface Parking {

    boolean park(Car car);

    boolean remove(Car car);

    int getCarPlaces();

    int getTruckPlaces();

    List<Car> getCars();
}
