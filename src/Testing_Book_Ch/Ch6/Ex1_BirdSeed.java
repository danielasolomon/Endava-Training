package Testing_Book_Ch.Ch6;

public class Ex1_BirdSeed {
    private int numberBags;
    boolean call;

    public Ex1_BirdSeed(){
        this(2);
        call = false;

    }

    public Ex1_BirdSeed(int numberBags){
        this.numberBags = numberBags;
    }

    public static void main(String[] args) {
        var seed = new Ex1_BirdSeed();
        System.out.println(seed.numberBags);
    }
}
