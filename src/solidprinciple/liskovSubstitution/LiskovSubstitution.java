package solidprinciple.liskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitution {
    public static void main(String[] args) {
        List<Vehicle> vechleList= new ArrayList<>();
        vechleList.add(new MotorCycle());
        vechleList.add(new Car());
        vechleList.add(new Bicycle());

        for(Vehicle vehicle:vechleList){
            System.out.println(vehicle.hasEngine().toString());
        }
    }
}

class Vehicle {
    public int getNumberOfWheels() {
        return 2;
    }

    public Boolean hasEngine() {
        return true;
    }
}

class MotorCycle extends Vehicle {

}

class Car extends Vehicle {
    @Override
    public int getNumberOfWheels() {
        return 4;
    }
}

class Bicycle extends Vehicle{
    @Override
    public Boolean hasEngine(){
        return null;
    }
}