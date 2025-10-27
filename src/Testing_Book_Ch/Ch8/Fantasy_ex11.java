package Testing_Book_Ch.Ch8;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Fantasy_ex11 {
    public static void scary(String animal){
        //var dino = s -> "dino".equals(animal);
        //var dragon = s -> "dragon".equals(animal);
        Predicate<String> dino = s -> "dino".equals(animal);
        Predicate<String> dragon = s -> "dragon".equals(animal);
        var combined = dino.or(dragon);
        System.out.println(combined.test(animal));

        // ex 13
        int length = 3;

        for (int i = 0; i<3; i++) {
            if (i%2 == 0) {
                Supplier<Integer> supplier = () -> length;
                System.out.println(supplier.get());
            } else {
                int j = i;
                Supplier<Integer> supplier = () -> j;
                System.out.println(supplier.get());
            }
        }

    }
    public static void main(String[] args) {
        scary("dino");
        scary("dragon");
        scary("unicorn");
    }
}
