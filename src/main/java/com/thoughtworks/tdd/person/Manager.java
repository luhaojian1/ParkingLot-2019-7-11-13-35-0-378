package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.exception.NotEnoughPositionException;
import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {
    private List<Parker> parkers = new ArrayList<>();

    public Manager(Parker... parkers) {
        this.parkers.addAll(Arrays.asList(parkers));
    }

    public CarTicket parkCar(Car car) {
        boolean ishasParker = parkers.stream().anyMatch(Parker::isHasAvailableParkingLot);
        if (ishasParker) {
            Parker parker = parkers.stream().filter(Parker::isHasAvailableParkingLot).collect(Collectors.toList()).get(0);
            return parker.parkCar(car);
        }
        return null;
    }

    public Car takeCar(CarTicket carTicket) {
        boolean isContainsCarTicket = parkers.stream().anyMatch(parker -> parker.isContainsCarTicket(carTicket));
        if (isContainsCarTicket) {
            Parker targetParker = parkers.stream().filter(parker -> parker.isContainsCarTicket(carTicket)).collect(Collectors.toList()).get(0);
            return targetParker.takeCar(carTicket);
        }
        return null;
    }

    public List<Parker> getParkers() {
        return parkers;
    }

    public void setParkers(List<Parker> parkers) {
        this.parkers = parkers;
    }
}
