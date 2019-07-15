package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.exception.CarTicketMissingException;
import com.thoughtworks.tdd.exception.NotEnoughPositionException;
import com.thoughtworks.tdd.exception.UnrecognizedParkingTicketException;
import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy extends Parker {


    public ParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }
    public ParkingBoy(ParkingLot... parkingLots) {
        super.parkingLots.addAll(Arrays.asList(parkingLots));
    }
    public CarTicket parkCar(Car car) {
        boolean isAllParkingLotFull = parkingLots.stream().allMatch(ParkingLot::isParkingLotFull);
        if (!isAllParkingLotFull) {
            ParkingLot targetParkingLot = parkingLots.stream()
                    .filter(parkingLot -> !parkingLot.isParkingLotFull()).collect(Collectors.toList()).get(0);
            return targetParkingLot.parkCar(car);
        }
        throw new NotEnoughPositionException();
    }


}
