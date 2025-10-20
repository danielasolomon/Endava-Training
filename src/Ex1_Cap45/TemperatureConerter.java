package Ex1_Cap45;

public class TemperatureConerter {
    public static double converting(double fahrenheit){
            return (fahrenheit - 32) * 5 / 9;
    }

    public static double converting(float celsius){
        return (celsius * 9 / 5) + 32;
    }
}
