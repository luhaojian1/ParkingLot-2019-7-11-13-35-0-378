package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    private ParkingLot parkingLot;

    @Test
    public void should_renturn_error_message_when_takeCar_given_error_carTicket() {
        parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //given
        CarTicket errorCarTicket = new CarTicket();
        //when
        Car car = parkingBoy.takeCar(errorCarTicket);
        //then
        assertEquals(car.getCarMessage(), "Unrecognized parking ticket.");
    }

    @Test
    public void should_renturn_error_message_when_takeCar_given_no_carTicket() {
        parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //given
        CarTicket noCarTicket = null;
        //when
        Car car = parkingBoy.takeCar(noCarTicket);
        //then
        assertEquals(car.getCarMessage(), "Please provide your parking ticket.");
    }
}
