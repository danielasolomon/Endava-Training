import java.util.*;

public class NumberPicker {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10)); // număr între 0 și 9
        int cookies = 4;
        double reward = 3 + 2 * --cookies;
        System.out.print("Zoo animal receives: "+reward+" reward points");
    }
}
