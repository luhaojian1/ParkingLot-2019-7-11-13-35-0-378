package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_parkLot1_length_is_6_when_parkingCar_given_3_parkLots() {
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(30);
        ParkingLot parkingLot3 = new ParkingLot();
        ParkingBoy parkingBoy = new SuperSmartParkingBoy();
        //given
        for (int i = 0; i < 4; i++) {
            parkingLot1.parkCar(new Car());
            parkingLot3.parkCar(new Car());
        }
        parkingLot2.setIsFull(true);
        parkingLot1.parkCar(new Car());
        parkingBoy.setParkingLots(parkingLot1);
        parkingBoy.setParkingLots(parkingLot2);
        parkingBoy.setParkingLots(parkingLot3);
        //when
        CarTicket carTicket = parkingBoy.parkingCar(new Car());
        int parkingLot1Length = parkingLot1.getParkRecords().size();
        //then

        assertEquals(parkingLot1Length, 6);
    }
}
