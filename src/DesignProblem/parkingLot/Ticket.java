package DesignProblem.parkingLot;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;
    private final ParkingSpot spot;


    public Ticket(String ticketId, Vehicle vehicle, LocalDateTime entryTime, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.spot = spot;
    }

    public long getDurationInHours(){
        return Duration.between(entryTime,LocalDateTime.now()).toHours();
    }

    public Vehicle getVehicle() { return vehicle; }

    public ParkingSpot getSpot() { return spot; }

    public String getTicketId() { return ticketId; }
}
