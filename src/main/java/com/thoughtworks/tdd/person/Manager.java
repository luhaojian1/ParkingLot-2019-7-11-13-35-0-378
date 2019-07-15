package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<ParkingBoy> parkingBoys = new ArrayList<>();

    public CarTicket pointParkingBoyToParkCar(Car car, ParkingBoy parkingBoy) {
        if (!parkingBoys.contains(parkingBoy)) {
            parkingBoys.add(parkingBoy);
        }
        return parkingBoy.parkCar(car);
    }

    public Car pointParkingBoyToTakeCar(CarTicket carTicket, ParkingBoy parkingBoy) {
        if (!parkingBoys.contains(parkingBoy)) {
            parkingBoys.add(parkingBoy);
        }
        return parkingBoy.takeCar(carTicket);
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void addParkingBoys(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }
}
