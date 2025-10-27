package Testing_Book_Ch.Ch8;
 import java.util.function.*;

public class Ex17 {
    int age;
    public static void main(String[] args) {
        Ex17 p1 = new Ex17();
        p1.age = 1;
        check(p1, p -> p1.age < 5 );
    }
    private static void check(Ex17 panda, Predicate<Ex17> pred) {
        String result = pred.test(panda) ? "yes" : "no";
        System.out.println(result);
    }

}
