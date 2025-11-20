package solidprinciple.opencloseprinciple;


import java.awt.*;

public class AreaCalculator {

    public double area(Shape shape) {
        double areaOfShape = 0;
        if (shape instanceof Square) {
            // calculate the area of Square
        } else if (shape instanceof Circle) {
            // calculate the area of Circle
        }else if (shape instanceof Rectangle){
            //    // calculate the area of rectangle
        }
        return areaOfShape;
    }
}

class Shape {

}

class Square extends Shape {

}

class Circle extends Shape {

}

class Rectangle extends Shape {

}