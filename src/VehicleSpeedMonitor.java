import java.util.Scanner;

public class VehicleSpeedMonitor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Write vehicle type (car, bus, bike): ");
            String vehicleType = scan.nextLine().trim();

            System.out.println("Write speed: ");
            double speed = scan.nextDouble();
            scan.nextLine(); // clear buffer after number read

            if(speed < 0) {
                System.out.println("Exit program");
                running = false;
                break;
            }

            // pattern matching
            int speedLimit = switch (vehicleType.toLowerCase()) {
                case "car" -> 100;
                case "bus" -> 80;
                case "bike" -> 60;
                default -> -1;
            };

            if (speedLimit == -1) {
                System.out.println("Unknow vehicle type");
            }
            else{
                if (speed <= speedLimit) {
                    System.out.println("Speed OK");
                } else {
                    System.out.println("Speeding!");
                }
            }
            System.out.println();
        }

        scan.close();
    }
}