package com.thoughtworks.tdd.parklot;

import com.thoughtworks.tdd.person.Customer;

public class CarTicket {
    private Car car;
    private Customer customer;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
