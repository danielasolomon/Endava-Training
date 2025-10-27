package Testing_Book_Ch.Ch6;
abstract class Bird {
    private final void fly(){
        System.out.println("Bird");
    }
    protected Bird() {
        System.out.println("WoW-");
    }

}
public class Ex8_Pelican extends Bird {
    public Ex8_Pelican() {
        System.out.println("Oh-");
    }
    protected void fly(){
        System.out.println("Pelican");
    }
    public static void main(String[] args) {
        var chirp = new Ex8_Pelican();
        chirp.fly();

    }
}
