package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy extends Person {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket parkingCar(Car car) {
        CarTicket carTicket = parkingLot.parkCar(car);
        if (carTicket == null) {
            carTicket = new CarTicket();
            carTicket.setParkCarMessage("Not enough position.");
        }
       else{
           carTicket.setParkCarMessage("park car success");
        }
        return carTicket;
    }

    public Car takeCar(CarTicket carTicket) {
        Car car;
        if (carTicket == null) {
            car = new Car();
            car.setCarMessage("Please provide your parking ticket.");
        } else {
            car = parkingLot.pickUpCar(carTicket);
            if (car == null) {
                car = new Car();
                car.setCarMessage("Unrecognized parking ticket.");
            } else {
                car.setCarMessage("pick up car success.");
            }
        }
        return car;
    }
}
