package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {

    @Test
    public void should_return_correct_parkLot_length_when_pointParkingBoyToParkCar_given_parkingCar_and_parkingBoy() {
        Manager manager = new Manager();
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(22);
        ParkingLot parkingLot3 = new ParkingLot(19);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        //given
        for (int i = 0; i < 4; i++) {
            parkingLot2.parkCar(new Car());
            parkingLot3.parkCar(new Car());
        }
        parkingLot1.setIsFull(true);
        parkingLot2.parkCar(new Car());
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
        int parkingLot1Capacity = parkingLot1.getParkRecords().size();
        int parkingLot2Capacity = parkingLot2.getParkRecords().size();
        int parkingLot3Capacity = parkingLot3.getParkRecords().size();
        //then
        assertEquals(parkingLot1Capacity, 0);
        assertEquals(parkingLot2Capacity, 7);
        assertEquals(parkingLot3Capacity, 5);

    }

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
        assertEquals(carTicket.getParkCarMessage(), "Not enough position.");
        assertEquals(smartBoyCarTicket.getParkCarMessage(), "Not enough position.");
        assertEquals(superSmartBoyCarTicket.getParkCarMessage(), "Not enough position.");

    }

    @Test
    public void should_return_error_message_when_pointParkingBoyToTakeCar_given_parkingCar_and_parkingBoy() {
        Manager manager = new Manager();
        ParkingLot parkingLot1 = new ParkingLot(20);
        ParkingLot parkingLot2 = new ParkingLot(22);
        ParkingLot parkingLot3 = new ParkingLot(19);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
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
        carTicket.setUsed(true);
        CarTicket smartBoyCarTicket = null;
        CarTicket superSmartBoyCarTicket = superSmartParkingBoy.parkingCar(new Car());
        CarTicket managerCarTicket = manager.parkingCar(new Car());
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


}
