package Ex1_Cap45;

import java.util.Scanner;
import static Ex1_Cap45.TemperatureConerter.converting;

public class TemperatureConverterMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter temperature: ");
        double val = sc.nextDouble();
        System.out.println("Enter unit C/F");
        String unit = sc.next().trim().toUpperCase();

        double result;

        if(unit.equals("C")){
            result = converting((float) val);
            System.out.printf("%2f C = %2f F%n", val, result);

        }else if(unit.equals("F")){
            result = converting(val);
            System.out.printf("%2f F = %2f C%n", val, result);

        } else{
            System.out.println("Invalid unit");
        }
        sc.close();
    }
}
