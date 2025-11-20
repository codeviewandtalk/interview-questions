package DesignProblem.parkingLot;

public class Vehicle {
    private final String licencePlate;

    public Vehicle(String licencePlate) {
        this.licencePlate = licencePlate;
    }
    public String getLicencePlate(){
        return this.licencePlate;
    }
}

class Car extends Vehicle{

    public Car(String licencePlate) {
        super(licencePlate);
    }
}

class Bike extends Vehicle{
    public Bike(String licencePlate){
        super(licencePlate);
    }
}

class Truck extends Vehicle{

    public Truck(String licencePlate) {
        super(licencePlate);
    }
}