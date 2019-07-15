package com.thoughtworks.tdd.parklot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void should_return_3_carTickets_when_parkCar_given_3_cars() {
        List<CarTicket> carTickets = new ArrayList<>();
        parkingLot = new ParkingLot();
        for (int i = 0; i < 3; i++) {
            //given
            Car car = new Car();
            //when
            carTickets.add(parkingLot.parkCar(car));
        }
        //then
        assertEquals(carTickets.size(), 3);
    }

    @Test
    public void should_return_2_cars_when_takeCar_given_2_carTickets() {
        List<Car> cars = new ArrayList<>();
        parkingLot = new ParkingLot();
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        CarTicket ticket1 = parkingLot.parkCar(car1);
        CarTicket ticket2 = parkingLot.parkCar(car2);
        //when
        cars.add(parkingLot.takeCar(ticket1));
        cars.add(parkingLot.takeCar(ticket2));
        //then
        assertEquals(cars.size(), 2);
    }

    @Test
    public void should_return_null_when_takeCar_given_error_carTicket() {
        parkingLot = new ParkingLot();
        //given
        CarTicket errorTicket = new CarTicket();
        //when
        Car errorTicketCar = parkingLot.takeCar(errorTicket);
        //then
        assertNull(errorTicketCar);
    }

    @Test
    public void should_return_null_when_takeCar_given_have_used_carTicket() {
        parkingLot = new ParkingLot();
        //given
        CarTicket usedTicket = new CarTicket();
        usedTicket.setUsed(true);
        //when
        Car errorTicketCar = parkingLot.takeCar(usedTicket);
        //then
        assertNull(errorTicketCar);
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
