package Testing_Book_Ch.Ch7;

class Primate{
    protected int age = 2;
    {age = 1;}
    public Primate() {
        this.age = 3;
    }
}

public class Ex29_Orangutan extends Primate{
    protected int age = 4;
    {age = 5;}
    public Ex29_Orangutan() {
        this.age = 6;
    }

    public static void main(String[] args) {
        final Primate x = (Primate)new Ex29_Orangutan();
        System.out.println(x.age);
    }
}
