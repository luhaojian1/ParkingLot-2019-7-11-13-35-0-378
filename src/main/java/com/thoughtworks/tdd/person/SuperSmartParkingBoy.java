package com.thoughtworks.tdd.person;

import com.thoughtworks.tdd.parklot.Car;
import com.thoughtworks.tdd.parklot.CarTicket;
import com.thoughtworks.tdd.parklot.ParkingLot;

import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    public CarTicket parkingCar(Car car) {
        CarTicket carTicket = new CarTicket();
        ;
        List<ParkingLot> parkingLots = getParkingLots().stream()
                .filter(falseParkingLot -> !falseParkingLot.isParkingLotFull())
                .collect(Collectors.toList());
        double availablePositionRate = 0;
        if (!parkingLots.isEmpty()) {
            ParkingLot targetParkingLot = null;
            for (ParkingLot parkingLot : parkingLots) {
                double availableRate = (double) (parkingLot.getCapacity() - parkingLot.getParkRecords().size()) / (double) parkingLot.getCapacity();
                if (availableRate >= availablePositionRate) {
                    availablePositionRate = availableRate;
                    targetParkingLot = parkingLot;
                }
            }
            carTicket = targetParkingLot.parkCar(car);

            return carTicket;
        }

        return carTicket;
    }
}
