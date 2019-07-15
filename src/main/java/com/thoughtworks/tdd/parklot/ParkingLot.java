package com.thoughtworks.tdd.parklot;

import com.thoughtworks.tdd.person.Parkable;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {

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

    public Car takeCar(CarTicket carTicket) {
        if (parkRecords.containsKey(carTicket)) {
            return parkRecords.remove(carTicket);
        }
        return null;
    }

    public boolean isParkingLotFull() {
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

    public boolean isUsedTicked(CarTicket carTicket) {
        return parkRecords.containsKey(carTicket);
    }
}
