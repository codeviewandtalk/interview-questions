package solidprinciple.interfacesegregation;

public class WithoutInterfaceSegregation {
}

interface IShapeAreaCalculator{
    double calculateArea();
    double calculateVolume();
}

class Square implements IShapeAreaCalculator{

    @Override
    public double calculateArea() {
        //dummy implementation
        return 0;
    }

    @Override
    public double calculateVolume() {
        //dummy implementation
        return 0;
    }
}