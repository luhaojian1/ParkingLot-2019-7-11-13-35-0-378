package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public CarTicket parkingCar(Car car) {
        CarTicket carTicket;
        List<ParkingLot> parkingLots = getParkingLots().stream()
                .filter(falseParkingLot -> !falseParkingLot.isFull())
                .collect(Collectors.toList());
        int minLength = 10;
        if (!parkingLots.isEmpty()) {
            ParkingLot targetParkingLot = null;
            for (ParkingLot parkingLot : parkingLots) {
                int length = parkingLot.getParkRecords().size();
                if (minLength >= length) {
                    minLength = length;
                    targetParkingLot = parkingLot;
                }
            }
            carTicket =targetParkingLot.parkCar(car);
            carTicket.setParkCarMessage("park car success.");
            return carTicket;
        }

        carTicket = new CarTicket();
        carTicket.setParkCarMessage("Not enough position.");
        return carTicket;
    }
}
