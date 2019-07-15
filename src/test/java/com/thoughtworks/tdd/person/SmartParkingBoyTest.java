package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    public void should_park_car_in_parkingLot3_success_when_parkCar_given_3_parkLots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot parkingLot3 = new ParkingLot(3);
        Parker smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2, parkingLot3);
        //given

        parkingLot2.setIsFull(true);
        parkingLot3.parkCar(new Car());
        //when
        CarTicket carTicket = smartParkingBoy.parkCar(new Car());
        int parkingLot3Size = parkingLot3.getParkRecords().size();
        //then
        assertNotNull(carTicket);
        assertEquals(parkingLot3Size, 2);
    }
}
