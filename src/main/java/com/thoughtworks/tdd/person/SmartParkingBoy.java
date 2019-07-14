package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public CarTicket parkingCar(Car car) {
        CarTicket carTicket = new CarTicket();
        List<ParkingLot> parkingLots = getParkingLots().stream()
                .filter(falseParkingLot -> !falseParkingLot.isFull())
                .collect(Collectors.toList());
        int maxLength = 0;
        if (!parkingLots.isEmpty()) {
            ParkingLot targetParkingLot = null;
            for (ParkingLot parkingLot : parkingLots) {
                int length = parkingLot.getCapacity()-parkingLot.getParkRecords().size();
                if (maxLength <= length) {
                    maxLength = length;
                    targetParkingLot = parkingLot;
                }
            }
            carTicket =targetParkingLot.parkCar(car);
            carTicket.setParkCarMessage("park car success.");
            return carTicket;
        }
        carTicket.setParkCarMessage("Not enough position.");
        return carTicket;
    }
}
