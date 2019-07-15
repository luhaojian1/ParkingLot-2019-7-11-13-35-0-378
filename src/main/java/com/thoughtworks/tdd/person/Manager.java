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

public class Manager {
    private List<Parker> parkers = new ArrayList<>();
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public Manager(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public Manager(Parker... parkers) {
        this.parkers.addAll(Arrays.asList(parkers));
    }

    public CarTicket parkCar(Car car) {
        boolean ishasParker = parkers.stream().anyMatch(Parker::isHasAvailableParkingLot);
        if (ishasParker) {
            Parker parker = parkers.stream().filter(Parker::isHasAvailableParkingLot).collect(Collectors.toList()).get(0);
            return parker.parkCar(car);
        } else {
            boolean isOwnParingLotsAvailable = parkingLots.stream().anyMatch(parkingLot -> !parkingLot.isParkingLotFull());
            if (isOwnParingLotsAvailable) {
                ParkingLot targetParkingLot = parkingLots.stream().filter(parkingLot -> !parkingLot.isParkingLotFull()).collect(Collectors.toList()).get(0);
                return targetParkingLot.parkCar(car);
            }
        }
        throw new NotEnoughPositionException();
    }

    public Car takeCar(CarTicket carTicket) {
        if (carTicket == null) {
            throw new CarTicketMissingException();
        }
        boolean isContainsCarTicket = parkers.stream().anyMatch(parker -> parker.isContainsCarTicket(carTicket));
        if (isContainsCarTicket) {
            Parker targetParker = parkers.stream().filter(parker -> parker.isContainsCarTicket(carTicket)).collect(Collectors.toList()).get(0);
            return targetParker.takeCar(carTicket);
        } else {
            boolean isOwnParKingLotContainsTicket = parkingLots.stream().anyMatch(parkingLot -> !parkingLot.isContainsTicket(carTicket));
            if (isOwnParKingLotContainsTicket) {
                ParkingLot targetParkingLot = parkingLots.stream().filter(parkingLot -> parkingLot.isContainsTicket(carTicket)).collect(Collectors.toList()).get(0);
                return targetParkingLot.takeCar(carTicket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
