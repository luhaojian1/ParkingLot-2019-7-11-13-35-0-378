package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;
import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import java.util.ArrayList;
import java.util.List;

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
    public void should_return_2_cars_when_pickUpCar_given_2_carTickets() {
        List<Car> cars = new ArrayList<>();
        parkingLot = new ParkingLot();
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        CarTicket ticket1 = parkingLot.parkCar(car1);
        CarTicket ticket2 = parkingLot.parkCar(car2);
        //when
        cars.add(parkingLot.pickUpCar(ticket1));
        cars.add(parkingLot.pickUpCar(ticket2));
        //then
        assertEquals(cars.size(), 2);
    }

    @Test
    public void should_return_null_when_pickUpCar_given_error_carTicket() {

        parkingLot = new ParkingLot();
        //given
        CarTicket errorTicket = new CarTicket();
        //when
        Car errorTicketCar = parkingLot.pickUpCar(errorTicket);
        //then
        assertNull(errorTicketCar);
    }

    @Test
    public void should_return_null_when_pickUpCar_given_have_used_carTicket() {

        parkingLot = new ParkingLot();
        //given
        CarTicket usedTicket = new CarTicket();
        usedTicket.setUsed(true);
        //when
        Car errorTicketCar = parkingLot.pickUpCar(usedTicket);
        //then
        assertNull(errorTicketCar);
    }

}
