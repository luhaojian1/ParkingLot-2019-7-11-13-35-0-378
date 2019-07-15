package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {
    private ParkingLot parkingLot;

    @Test
    public void should_return_error_message_when_takeCar_given_error_carTicket() {
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
    public void should_return_error_message_when_takeCar_given_no_carTicket() {
        parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //given
        CarTicket noCarTicket = null;
        //when
        Car car = parkingBoy.takeCar(noCarTicket);
        //then
        assertEquals(car.getCarMessage(), "Please provide your parking ticket.");
    }

    @Test
    public void should_return_error_message_when_parkingCar_given_fullCapacity() {
        parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //given
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkingCar(new Car());
        }
        //when
        CarTicket carTicket = parkingBoy.parkingCar(new Car());
        //then

    }

    @Test
    public void should_return_park_car_success_when_parkingCar_given_fullCapacity_in_first_parkingLot_and_park_to_the_second_parkLot() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy();
        //given
        parkingLot1.setIsFull(true);
        parkingBoy.setParkingLots(parkingLot1);
        parkingBoy.setParkingLots(parkingLot2);
        //when
        CarTicket carTicket = parkingBoy.parkingCar(new Car());
        //then

    }
}
