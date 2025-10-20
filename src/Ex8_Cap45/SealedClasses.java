package Ex8_Cap45;

sealed class Transport permits Car, Bike, Bus{
    String color;
    Transport (String color){
        this.color = color;
    }
    void moving(){
        System.out.println(color + " car is moving");
    }
}

final class Car extends Transport {
    String type;

    Car(String color, String type){
        super(color);
        this.type = type;
    }

    @Override
    void moving(){
        System.out.println(color + " car of brand " + type + " is moving");
    }
}

final class Bike extends Transport {
    boolean equipment;

    Bike(String color, boolean equipment){
        super(color);
        this.equipment = equipment;
    }

    @Override
    void moving(){
        System.out.println(color + " bike is mooving. Biker has echipament? -> " + equipment );
    }
}

final class Bus extends Transport {
    int people;

    Bus(String color, int people){
        super(color);
        this.people = people;
    }

    @Override
    void moving(){
        System.out.println(color + " bus is mooving with " + people + " people" );
    }
}

public class SealedClasses {
    public static void main(String[] args) {
        Transport car = new Car("blue", "Ford");
        Transport bike = new Bike("white", true);
        Transport bus = new Bus("yellow", 20);

        car.moving();
        bike.moving();
        bus.moving();

        System.out.println();

        Transport[] vehicles = {car,bike,bus};
        for (Transport vehicle : vehicles) {
            vehicle.moving();
        }
    }
}
