package Testing_Book_Ch.Ch11;

public class Ex20_DriveBus {
    public void go(){
        System.out.println("A");
        try{
            stop();
        }catch (ArithmeticException e){
            System.out.println("B");
        }finally {
            System.out.println("C");
        }
        System.out.println("D");
    }

    public void stop(){
        System.out.println("E");
        Object x = 3;
        x.toString();
        System.out.println("F");
    }

    public static void main(String[] args) {
        new Ex20_DriveBus().go();
    }

}
