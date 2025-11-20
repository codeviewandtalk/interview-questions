package DesignProblem.parkingLot;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final String name;
    private final List<ParkingSpot> spots;

    public ParkingFloor(String name, List<ParkingSpot> spots) {
        this.name = name;
        this.spots = spots;
    }

    public Optional<ParkingSpot> getAvailableSpots(VehicleType type){
      return spots.stream().filter(ParkingSpot::isAvailable).findFirst();
    }

    public List<ParkingSpot> getAllSpots(){
        return spots;
    }
}
