package Testing_Book_Ch.Ch7;

public class Ex13_Weather {
    enum Seasons {
        WINTER, SPRING, SUMMER, FALL
    }

    public static void main(String[] args) {
        Seasons v = Seasons.SPRING;
        switch (v) {
            case Seasons.SPRING -> System.out.print("s");
            case Seasons.WINTER -> System.out.print("w");
            case Seasons.SUMMER -> System.out.print("m");
            default -> System.out.println("missing data"); }
    } }