package DesignProblem.parkingLot;

public class ParkingSpot {
    private final String id;
    private final VehicleType type;
    private boolean isOccupied;
    private Vehicle currentVehicle;


    public ParkingSpot(String id, VehicleType type) {
        this.id = id;
        this.type = type;
    }

    public boolean park(Vehicle vehicle) {
        if (!isOccupied) {
            this.currentVehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public void unPark(){
        this.currentVehicle=null;
        this.isOccupied=false;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public VehicleType getType(){
        return type;
    }
}
