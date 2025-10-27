package Testing_Book_Ch.Ch5;

public class Ex20_Run {
    static void execute(){
        System.out.println("1-");
    }
    static void execute(int num){
        System.out.println("2-");
    }
    static void execute(Integer num){
        System.out.println("3-");
    }
    static void execute(Object num){
        System.out.println("4-");
    }
    static void execute(int... num){
        System.out.println("5-");
    }
    public static void main(String[] args) {
        Ex20_Run.execute(100);
        Ex20_Run.execute(100L);
    }
}
