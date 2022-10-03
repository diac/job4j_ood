package ru.job4j.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleParkingTest {

    @Test
    public void whenParkTwoPassengerCarsAndOneTruck() {
        Parking parking = new SimpleParking(2, 1);
        Car firstCar = new PassengerCar("First Car");
        Car secondCar = new PassengerCar("Second Car");
        Car truck = new Truck("Truck", 5);
        parking.park(firstCar);
        parking.park(secondCar);
        parking.park(truck);
        assertThat(parking.getCars()).containsExactlyInAnyOrder(firstCar, secondCar, truck);
    }

    @Test
    public void whenParkSmallTruckAndBigTruck() {
        Parking parking = new SimpleParking(2, 1);
        Car bigTruck = new Truck("Big Truck", 5);
        Car smallTruck = new Truck("Small Truck", 2);
        parking.park(bigTruck);
        parking.park(smallTruck);
        assertThat(parking.getCars()).containsExactlyInAnyOrder(smallTruck, bigTruck);
    }

    @Test
    public void whenParkTwoSmallTrucks() {
        Parking parking = new SimpleParking(2, 1);
        Car firstTruck = new Truck("First Truck", 2);
        Car secondTruck = new Truck("Second Truck", 2);
        parking.park(firstTruck);
        parking.park(secondTruck);
        assertThat(parking.getCars()).containsExactlyInAnyOrder(firstTruck, secondTruck);
    }

    @Test
    public void whenParkTwoBigTrucksAndNoPlaceAvailableForSecond() {
        Parking parking = new SimpleParking(2, 1);
        Car firstTruck = new Truck("First Truck", 5);
        Car secondTruck = new Truck("Second Truck", 5);
        parking.park(firstTruck);
        parking.park(secondTruck);
        assertThat(parking.getCars()).containsExactly(firstTruck);
        assertThat(parking.getCars()).doesNotContain(secondTruck);
    }

    @Test
    public void whenParkPassengerCarOnTruckPlace() {
        Parking parking = new SimpleParking(1, 1);
        Car firstCar = new PassengerCar("First Car");
        Car secondCar = new PassengerCar("Second Car");
        parking.park(firstCar);
        parking.park(secondCar);
        assertThat(parking.getCars()).doesNotContain(secondCar);
    }

    @Test
    public void whenRemove() {
        Parking parking = new SimpleParking(2, 1);
        Car firstCar = new PassengerCar("First Car");
        Car secondCar = new PassengerCar("Second Car");
        Car truck = new Truck("Truck", 5);
        parking.park(firstCar);
        parking.park(secondCar);
        parking.park(truck);
        parking.remove(secondCar);
        assertThat(parking.getCars()).containsExactlyInAnyOrder(firstCar, truck);
    }
}