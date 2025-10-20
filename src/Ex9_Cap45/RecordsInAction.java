package Ex9_Cap45;

import java.util.ArrayList;
import java.util.List;

record Person(String name, int age) {
    public Person{
        if (age<0){
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Age: " + age;
    }
}

public class RecordsInAction {
    public static void main(String[] args) {
        List <Person> people = List.of(
                new Person("Daniela",23),
                new Person("Alex", 23),
                new Person("Ana", 22)
        );

        for (Person p : people){
            System.out.println(p);
        }
    }
}
