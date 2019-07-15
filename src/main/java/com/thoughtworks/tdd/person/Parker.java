package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;

public abstract class Parker implements Parkable {

    @Override
    public abstract CarTicket parkCar(Car car);

    @Override
    public Car takeCar(CarTicket carTicket) {
        return null;
    }
}
