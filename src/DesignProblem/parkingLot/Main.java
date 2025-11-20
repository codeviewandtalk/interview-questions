package DesignProblem.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add(new ParkingSpot("C1", VehicleType.CAR));
        floor1Spots.add(new ParkingSpot("B1", VehicleType.BIKE));
        floor1Spots.add(new ParkingSpot("T1", VehicleType.TRUCK));

        ParkingFloor floor1 = new ParkingFloor("F1", floor1Spots);

        ParkingLot lot = new ParkingLot(List.of(floor1));

        Vehicle car = new Car("DL1234");
        Ticket ticket = lot.parkVehicle(car, VehicleType.CAR);
        System.out.println("Ticket issued: " + ticket.getTicketId());

        Thread.sleep(2000); // simulate 2 seconds

        double fee = lot.unparkVehicle(ticket.getTicketId());
        System.out.println("Fee: " + fee);

    }
}
