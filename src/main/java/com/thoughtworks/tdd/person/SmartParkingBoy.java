package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.exception.NotEnoughPositionException;
import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SmartParkingBoy extends Parker {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super.parkingLots.addAll(Arrays.asList(parkingLots));
    }
    @Override
    public CarTicket parkCar(Car car) {
        boolean isAllParkingLotFull = parkingLots.stream().allMatch(ParkingLot::isParkingLotFull);
        if (isAllParkingLotFull) {
            throw new NotEnoughPositionException();
        }
        ParkingLot parkingLot = parkingLots.stream()
                .filter(falseParkingLot -> !falseParkingLot.isParkingLotFull())
                .sorted(Comparator.comparingInt(ParkingLot::getAvailableParkNumbers).reversed()).collect(Collectors.toList()).get(0);
        return parkingLot.parkCar(car);
    }
}
