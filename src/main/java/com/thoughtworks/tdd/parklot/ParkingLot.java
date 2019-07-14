package com.thoughtworks.tdd.parklot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int capacity;
    private boolean isFull = false;
    private Map<CarTicket, Car> parkRecords = new HashMap<>();

    public ParkingLot() {
        capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket parkCar(Car car) {
        if (isFull) {
            return null;
        }
        CarTicket carTicket = new CarTicket();
        parkRecords.put(carTicket, car);
        if (parkRecords.size() >= capacity) {
            isFull = true;
        }
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

    public boolean isFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    public Map<CarTicket, Car> getParkRecords() {
        return parkRecords;
    }

    public int getCapacity() {
        return capacity;
    }
}
