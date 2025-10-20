package Ex5_Cap45;

import java.util.ArrayList;

class Animal {
    void makeSound(){
        System.out.println("Animal makeSound");
    }
}

class Mammal extends Animal {
    @Override
    void makeSound(){
        System.out.println("Mammal makeSound");
    }
}
class Bird extends Animal {
    @Override
    void makeSound(){
        System.out.println("Bird makeSound");
    }
}

class Dog extends Mammal {
    @Override
    void makeSound(){
        System.out.println("Ham Ham!");
    }
}

class Eagle extends Bird {
    @Override
    void makeSound(){
        System.out.println("Craaaa!");
    }
}
public class ZooInheritance {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<Animal>();

        animals.add(new Dog());
        animals.add(new Eagle());
        animals.add(new Mammal());
        animals.add(new Bird());

        for (Animal animal : animals) {
            animal.makeSound();

            if(animal instanceof Dog){
                System.out.println("=>Dog");
            }else if(animal instanceof Eagle){
                System.out.println("=>Eagle");
            }
        }
    }

}
