package DesignProblem.parkingLot;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private final List<ParkingFloor> floors;
    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private final double pricePerHour = 10.0;

    public ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public Ticket parkVehicle(Vehicle vehicle, VehicleType type) {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spot = floor.getAvailableSpots(type);
            if (spot.isPresent()) {
                boolean success = spot.get().park(vehicle);
                if (success) {
                    Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, LocalDateTime.now(), spot.get());
                    activeTickets.put(ticket.getTicketId(), ticket);
                    return ticket;
                }
            }
        }
        return null;
    }

    public double unparkVehicle(String ticketId){
        Ticket ticket= activeTickets.get(ticketId);

        if(ticket==null) return -1;
        ticket.getSpot().unPark();
        activeTickets.remove(ticketId);
        return ticket.getDurationInHours()*pricePerHour;
    }

    public void showAvailability(VehicleType type){
        for(ParkingFloor floor:floors){
            long available =floor.getAllSpots().stream()
                    .filter(spot->spot.getType()== type && spot.isAvailable()).count();
            System.out.println("Floor " + floor + ": " + available + " " + type + " spots available");
        }
    }
}
