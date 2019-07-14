package com.thoughtworks.tdd.parklot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int capacity = 10;
    private Map<CarTicket, Car> parkRecords = new HashMap<>();

    public CarTicket parkCar(Car car) {
        if (parkRecords.size() >= capacity){
            return null;
        }
        CarTicket carTicket = new CarTicket();
        parkRecords.put(carTicket, car);
        return carTicket;
    }

    public Car pickUpCar(CarTicket carTicket) {
        boolean isValidCarTicket = parkRecords.containsKey(carTicket) && !carTicket.isUsed();
        if (isValidCarTicket) {
            Car car = parkRecords.get(carTicket);
            parkRecords.remove(carTicket);
            return car;
        }

        return null;
    }
}
