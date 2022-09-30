package ru.job4j.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Disabled
class SimpleParkingTest {

    @Test
    public void whenParkTwoPassengerCarsAndOneTruck() {
        Parking parking = new SimpleParking(2, 1);
        Car firstCar = new PassengerCar();
        Car secondCar = new PassengerCar();
        Car truck = new Truck(5);
        parking.park(firstCar);
        parking.park(secondCar);
        parking.park(truck);
        assertThat(parking.getCars()).containsExactly(firstCar, secondCar, truck);
    }

    @Test
    public void whenParkSmallTruckAndBigTruck() {
        Parking parking = new SimpleParking(2, 1);
        Car smallTruck = new Truck(2);
        Car bigTruck = new Truck(5);
        parking.park(smallTruck);
        parking.park(bigTruck);
        assertThat(parking.getCars()).containsExactly(smallTruck, bigTruck);
    }

    @Test
    public void whenParkTwoSmallTrucks() {
        Parking parking = new SimpleParking(2, 1);
        Car firstTruck = new Truck(2);
        Car secondTruck = new Truck(2);
        parking.park(firstTruck);
        parking.park(secondTruck);
        assertThat(parking.getCars()).containsExactly(firstTruck, secondTruck);
    }

    @Test
    public void whenParkTwoBigTrucksAndNoPlaceAvailableForSecond() {
        Parking parking = new SimpleParking(2, 1);
        Car firstTruck = new Truck(5);
        Car secondTruck = new Truck(5);
        parking.park(firstTruck);
        parking.park(secondTruck);
        assertThat(parking.getCars()).containsExactly(firstTruck);
    }

    @Test
    public void whenRemove() {
        Parking parking = new SimpleParking(2, 1);
        Car firstCar = new PassengerCar();
        Car secondCar = new PassengerCar();
        Car truck = new Truck(5);
        parking.park(firstCar);
        parking.park(secondCar);
        parking.park(truck);
        parking.remove(secondCar);
        assertThat(parking.getCars()).containsExactly(firstCar, truck);
    }
}