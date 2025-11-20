package solidprinciple.liskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitutionSolution {
    public static void main(String[] args) {

        List<Vehicles> listOfVehicle = new ArrayList<>();
        listOfVehicle.add(new MotorCycles());
        listOfVehicle.add(new Cars());
        listOfVehicle.add(new Bicycles());

        for (Vehicles vehicleSolution : listOfVehicle) {
            System.out.println(vehicleSolution.getNumberOfWheels().toString());
        }


        List<EngineVehicle> listOfVehicles = new ArrayList<>();
        listOfVehicles.add(new MotorCycles());
        listOfVehicles.add(new Cars());


        for (EngineVehicle engineVehicle : listOfVehicles) {
            System.out.println(engineVehicle.hasEngine().toString());
        }
    }


}


class Vehicles {
    public Integer getNumberOfWheels() {
        return 2;
    }
}

class EngineVehicle extends Vehicles {
    public Boolean hasEngine() {
        return true;
    }
}

class MotorCycles extends EngineVehicle {

}

class Cars extends EngineVehicle {
    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }
}


class Bicycles extends Vehicles {

}