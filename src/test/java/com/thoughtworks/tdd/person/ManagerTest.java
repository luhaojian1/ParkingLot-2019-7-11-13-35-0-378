package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.exception.CarTicketMissingException;
import com.thoughtworks.tdd.exception.NotEnoughPositionException;
import com.thoughtworks.tdd.exception.UnrecognizedParkingTicketException;
import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerTest {

    @Test
    public void should_park_and_fetch_car_success_when_point_parker_to_parkCar_and_take_car() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(22);
        ParkingLot parkingLot3 = new ParkingLot(19);
        Parker parkingBoy = new ParkingBoy(parkingLot1);
        Parker smartParkingBoy = new SmartParkingBoy(parkingLot2);
        Parker superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot3);
        Manager manager = new Manager(parkingBoy, smartParkingBoy, superSmartParkingBoy);
        parkingLot1.setIsFull(true);
        parkingLot2.parkCar(new Car());
        Car car = new Car();

        CarTicket carTicket = manager.parkCar(car);
        Car targetCar = manager.takeCar(carTicket);

        assertEquals(targetCar, car);

    }

    @Test
    public void should_park_and_fetch_car_success_when_point_parker_to_parkCar_and_take_car_in_own_parking_lots() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        Manager manager = new Manager(parkingLot1, parkingLot2);
        parkingLot1.setIsFull(true);
        Car car = new Car();

        CarTicket carTicket = manager.parkCar(car);
        Car targetCar = manager.takeCar(carTicket);

        assertEquals(targetCar, car);

    }

    @Test
    public void should_throw_exception_when_park_and_take_car() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(22);
        Parker parkingBoy = new ParkingBoy(parkingLot1);
        Parker smartParkingBoy = new SmartParkingBoy(parkingLot2);
        Manager manager = new Manager(parkingBoy, smartParkingBoy);
        parkingLot1.setIsFull(true);
        parkingLot2.setIsFull(true);

        assertThrows(NotEnoughPositionException.class, () -> manager.parkCar(new Car()));
        assertThrows(CarTicketMissingException.class, () -> manager.takeCar(null));
        assertThrows(UnrecognizedParkingTicketException.class, () -> manager.takeCar(new CarTicket()));

    }


}
