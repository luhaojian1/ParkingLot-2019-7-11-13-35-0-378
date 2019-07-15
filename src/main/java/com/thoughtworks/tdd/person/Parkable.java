package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;

public interface Parkable {
    CarTicket parkCar(Car car);

    Car takeCar(CarTicket carTicket);
}
