package Testing_Book_Ch.Ch8;

import java.util.function.Predicate;

public class Ex15 {
    private int age = 1;
    public static void main(String[] args) {
        var p = new Ex15();
        double height = 10;
        int age = 1;
        //testLaugh(p,  var -> p.age <= 10);
        testLaugh(p,  h -> h.age < 5);
        age = 2;
    }
    static void testLaugh(Ex15 panda, Predicate<Ex15> joke) {
        var r = joke.test(panda) ? "hahaha" : "silence";
        System.out.print(r);
    }
}

