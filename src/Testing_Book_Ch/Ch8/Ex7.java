package Testing_Book_Ch.Ch8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Ex7 {
    public static void main(String[] args) {
        Ex7 e = new Ex7();
        e.method();
    }


    public void method() {
        x((var x) -> {}, (var x, var y) -> false);
    }
    public void x(Consumer<String> x, BinaryOperator<Boolean> y) {}

}



