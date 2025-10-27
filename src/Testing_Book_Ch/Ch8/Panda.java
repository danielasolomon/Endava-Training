package Testing_Book_Ch.Ch8;

import java.util.function.*;
public class Panda {
    int age;
    public static void main(String[] args) {
        Panda p1 = new Panda();
        p1.age = 1;
        check(p1, p-> p.age <5);
    }
    private static void check(Panda panda,
                              Predicate<Panda> pred) {
        String result =
                pred.test(panda) ? "yes" : "no";
        System.out.println(result);
    }
}
