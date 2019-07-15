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

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy() {
        this.parkingLots = new ArrayList<>();
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
    }

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots.addAll(Arrays.asList(parkingLots));
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


    public Car takeCar(CarTicket carTicket) {
        if (carTicket == null) {
            throw new CarTicketMissingException();
        } else {
            boolean isContainTicket = parkingLots.stream().anyMatch(parkingLot -> parkingLot.isContainsTicket(carTicket));
            if (isContainTicket) {
                ParkingLot targetParkingLot = parkingLots.stream()
                        .filter(parkingLot -> parkingLot.isContainsTicket(carTicket)).collect(Collectors.toList()).get(0);
                return targetParkingLot.takeCar(carTicket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public void addParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
