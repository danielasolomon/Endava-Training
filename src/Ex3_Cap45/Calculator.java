package Ex3_Cap45;

public class Calculator {
    public int add (int a, int b) {
        System.out.println("Method called add(int, int)");
        return a + b;
    }

    public double add (double a, double b) {
        System.out.println("Method called add(double, double)");
        return a + b;
    }

    public double add (int a, double b) {
        System.out.println("Method called add(int, double)");
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int r1 = calc.add(1, 2);
        System.out.println(r1);

        double r2 = calc.add(1.5, 2.3);
        System.out.println(r2);

        double r3 = calc.add(1, 2.3);
        System.out.println(r3);

        double r4 = calc.add(1.5, 2);
        System.out.println(r4 + " -> Result for (double,int)");
    }
}
