package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
/*
    @Test
    public void should_return_error_message_when_pointParkingBoyToParkCar_given_parkingCar_and_parkingBoy() {
        Manager manager = new Manager();
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(22);
        ParkingLot parkingLot3 = new ParkingLot(19);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        //given
        parkingLot1.setIsFull(true);
        parkingLot2.setIsFull(true);
        parkingLot3.setIsFull(true);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        parkingBoy.addParkingLots(parkingLots);
        smartParkingBoy.addParkingLots(parkingLots);
        superSmartParkingBoy.addParkingLots(parkingLots);
        //when
        CarTicket carTicket = manager.pointParkingBoyToParkCar(new Car(), parkingBoy);
        CarTicket smartBoyCarTicket = manager.pointParkingBoyToParkCar(new Car(), smartParkingBoy);
        CarTicket superSmartBoyCarTicket = manager.pointParkingBoyToParkCar(new Car(), superSmartParkingBoy);
        //then


    }

    @Test
    public void should_return_error_message_when_pointParkingBoyToTakeCar_given_parkCar_and_parkingBoy() {
        Manager manager = new Manager();
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(22);
        ParkingLot parkingLot3 = new ParkingLot(19);
        Parker parkingBoy = new ParkingBoy();
        Parker smartParkingBoy = new SmartParkingBoy();
        Parker superSmartParkingBoy = new SuperSmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        parkingBoy.addParkingLots(parkingLots);
        smartParkingBoy.addParkingLots(parkingLots);
        superSmartParkingBoy.addParkingLots(parkingLots);
        manager.addParkingLots(parkingLots);
        //given
        parkingLot1.setIsFull(true);
        CarTicket carTicket = new CarTicket();
        CarTicket smartBoyCarTicket = null;
        CarTicket superSmartBoyCarTicket = superSmartParkingBoy.parkCar(new Car());
        CarTicket managerCarTicket = manager.parkCar(new Car());
        //when
        Car car = manager.pointParkingBoyToTakeCar(carTicket, parkingBoy);
        Car smartCar = manager.pointParkingBoyToTakeCar(smartBoyCarTicket, smartParkingBoy);
        Car superSmartCar = manager.pointParkingBoyToTakeCar(superSmartBoyCarTicket, superSmartParkingBoy);
        Car managerCar = manager.takeCar(managerCarTicket);
        //then
        assertEquals(car.getCarMessage(), "Unrecognized parking ticket.");
        assertEquals(smartCar.getCarMessage(), "Please provide your parking ticket.");
        assertEquals(superSmartCar.getCarMessage(), "pick up car success.");
        assertEquals(managerCar.getCarMessage(), "pick up car success.");

    }
*/

}
