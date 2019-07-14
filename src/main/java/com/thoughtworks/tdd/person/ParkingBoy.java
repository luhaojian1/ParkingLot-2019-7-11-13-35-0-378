package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy extends Person {
    private List<ParkingLot> parkingLots;

    public ParkingBoy() {
        this.parkingLots = new ArrayList<>();
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots = parkingLots;
    }

    public CarTicket parkingCar(Car car) {
        CarTicket carTicket;
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                carTicket = parkingLot.parkCar(car);
                carTicket.setParkCarMessage("park car success.");
                return carTicket;
            }
        }
        carTicket = new CarTicket();
        carTicket.setParkCarMessage("Not enough position.");
        return carTicket;
    }


    public Car takeCar(CarTicket carTicket) {
        Car car;
        if (carTicket == null) {
            car = new Car();
            car.setCarMessage("Please provide your parking ticket.");
            return car;
        } else {
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.getParkRecords().containsKey(carTicket)) {
                    car = parkingLot.pickUpCar(carTicket);
                    car.setCarMessage("pick up car success.");
                    return car;
                }
            }
            car = new Car();
            car.setCarMessage("Unrecognized parking ticket.");
            return car;
        }
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
