package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    private ParkingLot parkingLot;

    @Test
    public void should_renturn_error_message_when_parkCar_given_error_carTicket(){
        parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //given
        CarTicket errorCarTicket = new CarTicket();
        //when
        Car car = parkingBoy.takeCar(errorCarTicket);
        //then
        assertEquals(car.getCarMessage(),"未识别的停车罚单");
    }
}
