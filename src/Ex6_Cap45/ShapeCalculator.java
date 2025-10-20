package Ex6_Cap45;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double height;

    Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    double area() {
        return length * height;
    }

    @Override
    double perimeter() {
        return 2* (length + height);
    }
}

class Triangle extends Shape {
    double x, y, z;

    Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    @Override
    double area() {
        double s = (x + y + z) / 2;
        return Math.sqrt(s * (s - x) * (s - y) * (s - z));
    }

    @Override
    double perimeter() {
        return x + y + z;
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();

        shapes.add(new Circle(2));
        shapes.add(new Rectangle(2,3));
        shapes.add(new Triangle(2,3,4));

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName()+":");
            System.out.println(" Area = " + shape.area());
            System.out.println(" Perimeter = " + shape.perimeter() +"\n");
        }
    }
}
