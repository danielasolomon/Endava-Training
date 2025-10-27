package Testing_Book_Ch.Ch5;

public class Ex11 {
    public static void swing(){
        System.out.println("swing");
    }

    public void climb(){
        System.out.println("climb");
    }

    public static void play(){
        swing();
        //climb();
    }
    public static void main(String[] args) {
        Ex11 rope = new Ex11();
        rope.play();
        Ex11 rope2 = null;
        System.out.println("-");
        rope2.play();
    }

}
