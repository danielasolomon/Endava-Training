package Testing_Book_Ch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        String phoneNumber = "123-456-7890";
        System.out.println(hidePhone(phoneNumber));
    /*
        List<Integer> ls = Arrays.asList(1, 2, 3);
        ls.stream().forEach(System.out::print)
                .map(a->a*2)
                .forEach(System.out::print);

     */

        int[][] array = {{0}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}, {0, 1, 2, 3, 4}};
        var arr1 = array[4];
        //System.out.println(arr1[4][1]);
        System.out.println(array[4][1]);


        int rate = 10;
        int t = 5;
        double amount = 1000.0;
        for (int i = 1; i <= t; i++) {
            amount = amount * (1 - rate / 100.) * amount;

        }

        int i1 = 1, i2 = 2, i3 = 3;
        float i4 = i1 + (i2 = i3);
        System.out.println((int) i4);

        List<String> values = Arrays.asList("Alpha A", "Alpha B", "Alpha C");
        //boolean flag = values.stream().allMatch().get().equals("Alpha");
        //System.out.println(flag);
    }


    public static String hidePhone(String fullPhoneNumber) {
        return new StringBuilder(fullPhoneNumber).substring(0, 8) + "xxxx";
    }
}

class Super {
    static String ID = "QBANK";
}

class Sub extends Super {
    static {
        System.out.print("In Sub");
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        list.add("val1");
        list.add(2, "val2");
        list.add(1, "val3");
        System.out.println(list);
    }

    static int mx(int s) {
        for (int i = 0; i < 3; i++) {
            s = s + i;
        }
        return s;
    }
}