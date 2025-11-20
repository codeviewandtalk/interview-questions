package solidprinciple.opencloseprinciple;

public class OpenClosePrinciple {
}

/**
 * Implementation of open close principles
 */
interface IAreaCalculator {
    double Area();
}

class Squares implements IAreaCalculator {

    @Override
    public double Area() {
        System.out.println("Calculate area of square");
        return 0;
    }
}

class Circles implements IAreaCalculator {

    @Override
    public double Area() {
        System.out.println("Calculate area of circle");
        return 0;
    }


    class Rectangle implements IAreaCalculator{

        @Override
        public double Area() {
            System.out.println("Calculate area of rectangle");
            return 0;
        }
    }
}