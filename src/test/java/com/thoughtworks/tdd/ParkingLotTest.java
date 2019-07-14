package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;
import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @Test
    public void should_return_carTicket_when_parkCar_given_car() {
        //given
        parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        CarTicket carTicket = parkingLot.parkCar(car);
        //then
        assertNotNull(carTicket);

    }

    @Test
    public void should_return_car_when_pickUpCar_given_carTicket() {
        //given
        Car car = new Car();
        parkingLot = new ParkingLot();
        //when
        CarTicket carTicket = parkingLot.parkCar(car);
        //then
        assertNotNull(parkingLot.pickUpCar(carTicket));
    }
}
