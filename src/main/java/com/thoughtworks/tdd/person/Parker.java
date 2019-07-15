package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.exception.CarTicketMissingException;
import com.thoughtworks.tdd.exception.UnrecognizedParkingTicketException;
import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Parker implements Parkable {
    protected List<ParkingLot> parkingLots = new ArrayList<>();

    public Parker() {
    }

    public Parker(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Parker(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }
    @Override
    public abstract CarTicket parkCar(Car car);

    @Override
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

    public void setParkingLots(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public void addParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public boolean isHasAvailableParkingLot() {
        return parkingLots.stream().anyMatch(parkingLot -> !parkingLot.isParkingLotFull());
    }

    public boolean isContainsCarTicket(CarTicket carTicket) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.isContainsTicket(carTicket));
    }
}
