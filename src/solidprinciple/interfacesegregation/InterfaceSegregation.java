package solidprinciple.interfacesegregation;

public class InterfaceSegregation {
}

interface IAreaCalculator {
    double calculateArea();
}

interface IVolumeCalculator {
    double calculateVolume();
}

class Squares implements IAreaCalculator {

    @Override
    public double calculateArea() {
        return 0;
    }
}

class Cube implements IAreaCalculator, IVolumeCalculator {
    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public double calculateVolume() {
        return 0;
    }
}
