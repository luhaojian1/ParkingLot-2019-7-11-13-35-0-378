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

    public Car takeCar(CarTicket carTicket) {
        Car car = parkingLot.pickUpCar(carTicket);
        if (car == null) {
            car = new Car();
            car.setCarMessage("未识别的停车罚单");
        }
        else {
            car.setCarMessage("成功取车");
        }
        return car;
    }
}
