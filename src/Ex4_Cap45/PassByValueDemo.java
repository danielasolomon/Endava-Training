package Ex4_Cap45;

import java.util.Arrays;

public class PassByValueDemo {
    public static void modify(String name){
        name = "newName";
        System.out.println("name = " + name);
    }

    public static void modifyArray(int[] arr){
        arr[0] = 777;
        System.out.println("arr[0]= " + arr[0]);
    }

    public static void main(String[] args) {
        String myname = "Daniela";
        System.out.println("String before modify: " + myname);
        modify(myname);
        System.out.println("String after modify: " + myname);

        System.out.println();

        int[] nr = {1, 2, 3};
        System.out.println("Array before modify: " + Arrays.toString(nr));
        modifyArray(nr);
        System.out.println("Array after modify: " + Arrays.toString(nr));
    }
}
