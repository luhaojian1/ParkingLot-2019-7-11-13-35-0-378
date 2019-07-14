package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    public void should_return_parkLot3_length_is_5_when_parkingCar_given_3_parkLots() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingLot parkingLot3 = new ParkingLot();
        ParkingBoy parkingBoy = new SmartParkingBoy();
        //given
        for (int i = 0; i < 4; i++){
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
        int parkingLot3Length = parkingLot3.getParkRecords().size();
        //then
        assertEquals(carTicket.getParkCarMessage(), "park car success.");
        assertEquals(parkingLot3Length,5);
    }
}
