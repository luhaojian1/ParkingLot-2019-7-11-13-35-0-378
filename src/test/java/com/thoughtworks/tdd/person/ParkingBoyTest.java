package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.exception.CarTicketMissingException;
import com.thoughtworks.tdd.exception.NotEnoughPositionException;
import com.thoughtworks.tdd.exception.UnrecognizedParkingTicketException;
import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    private ParkingLot parkingLot;


    @Test
    public void should_throw_UnrecognizedParkingTicketException_when_takeCar_given_error_carTicket() {
        parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket errorCarTicket = new CarTicket();

        assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.takeCar(errorCarTicket));

    }

    @Test
    public void should_throw_CarTicketMissingException_when_takeCar_given_no_carTicket() {
        parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket noCarTicket = null;

        assertThrows(CarTicketMissingException.class, () -> parkingBoy.takeCar(noCarTicket));
    }

    @Test
    public void should_throw_NotEnoughPositionException_when_parkCar_given_fullCapacity() {
        parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.parkCar(new Car());

        assertThrows(NotEnoughPositionException.class, () -> parkingBoy.parkCar(new Car()));

    }

    @Test
    public void should_park_car_success_when_parkingCar_given_fullCapacity_in_first_parkingLot_and_park_to_the_second_parkLot() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);

        parkingLot1.setIsFull(true);
        CarTicket carTicket = parkingBoy.parkCar(new Car());
        int parkingLot2Size = parkingLot2.getParkRecords().size();

        assertNotNull(carTicket);
        assertEquals(1, parkingLot2Size);

    }
}
