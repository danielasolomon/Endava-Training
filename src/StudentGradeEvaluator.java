import java.util.Objects;
import java.util.Scanner;

public class StudentGradeEvaluator {

    public static double calculateAverage(int[] scores){
        int sum = 0;
        for(int s:scores){
            sum += s;
        }
        return (double) sum/scores.length;
    }

    public static String letterGrade(double average){
        return switch ((int) average / 10){
            case 10, 9 -> "A";
            case 8     -> "B";
            case 7     -> "C";
            case 6     -> "D";
            default    -> "F"; // 0->59
        };
    }

    public static String evaluateStudent(double average, int attendance){
        if(average >= 70 && attendance >= 75){
            return "PASS";
        }
        else if(average >= 50 && attendance < 70){
            return "RE-EXAM";
        }
        else return "FAIL";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Write student name or 'exit' for stop: ");
            Object nameObj = sc.nextLine();

            if(!(nameObj instanceof String name) || name.isEmpty()){
                System.out.println("Invalid student name. Try again ");
                continue;
            }

            if("exit".equalsIgnoreCase(name.trim())){
                System.out.println("Program terminated");
                break;
            }

            int[] scores = new int[3];
            System.out.println("Enter 3 scores: ");

            for(int i = 0; i < scores.length; i++){
                if(!sc.hasNextInt()){
                    System.out.println("Invalid number. Enter a valid score:");
                    sc.next();
                    i--;
                    continue;
                }

                int score = sc.nextInt();
                if(score<0 || score>100){
                    System.out.println("out of range. Enter a valid score: ");
                    i--;
                    continue;
                }
                scores[i] = score;
            }

            System.out.println("Enter attendance: ");
            int attendance;
            if(!sc.hasNextInt()){
                System.out.println("Invalid attendece. Skipping student: ");
                sc.nextLine();
                continue;

            }else{
                attendance = sc.nextInt();
            }
            sc.nextLine();

            if(attendance<0 || attendance>100){
                System.out.println("Out of range.");
                continue;
            }

            double average = calculateAverage(scores);
            String grade = letterGrade(average);
            String status = evaluateStudent(average, attendance);
            String attendanceStatus = (attendance >= 75) ? "attendance OK" : "attendane LOW";

            System.out.printf("average: %.1f%n", average);
            System.out.println("grade: " + grade + " status: " + status);
            System.out.println("(" + attendanceStatus + ")");
            System.out.println();
        }

        sc.close();
    }
}
