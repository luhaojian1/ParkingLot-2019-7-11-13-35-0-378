package com.thoughtworks.tdd.parklot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @Test
    public void should_park_car_and_fetch_car_success_when_parkCar_and_takeCar() {
        Car car = new Car();
        parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.parkCar(car);

        Car targetCar = parkingLot.takeCar(carTicket);

        assertEquals(targetCar, car);
    }

    @Test
    public void should_take_2_cars_success_when_parkCar_and_takeCar() {
        parkingLot = new ParkingLot();

        Car car1 = new Car();
        Car car2 = new Car();
        CarTicket ticket1 = parkingLot.parkCar(car1);
        CarTicket ticket2 = parkingLot.parkCar(car2);
        //when
        Car targetCar1 = parkingLot.takeCar(ticket1);
        Car targetCar2 = parkingLot.takeCar(ticket2);
        //then
        assertEquals(car1, targetCar1);
        assertEquals(car2, targetCar2);
    }

    @Test
    public void should_return_null_when_takeCar_given_error_carTicket() {
        parkingLot = new ParkingLot();
        CarTicket errorTicket = new CarTicket();

        Car errorTicketCar = parkingLot.takeCar(errorTicket);

        assertNull(errorTicketCar);
    }

    @Test
    public void should_return_null_when_takeCar_given_have_used_carTicket() {
        parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.parkCar(new Car());

        //when
        parkingLot.takeCar(carTicket);
        Car car2 = parkingLot.takeCar(carTicket);
        //then
        assertNull(car2);
    }

    @Test
    public void should_return_null_when_parkCar_given_fullCapacity() {
        parkingLot = new ParkingLot();
        //given
        for (int i = 0; i < 10; i++) {
            parkingLot.parkCar(new Car());
        }
        //when
        CarTicket ticket = parkingLot.parkCar(new Car());
        //then
        assertNull(ticket);
    }


}
