package com.thoughtworks.tdd.parklot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<CarTicket, Car> parkRecords = new HashMap<>();

    public CarTicket parkCar(Car car) {
        CarTicket carTicket = new CarTicket();
        parkRecords.put(carTicket, car);
        return carTicket;
    }

    public Car pickUpCar(CarTicket carTicket) {
        if (parkRecords.containsKey(carTicket)) {
            return parkRecords.get(carTicket);
        }
        return null;
    }
}
