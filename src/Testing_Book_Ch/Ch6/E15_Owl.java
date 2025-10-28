package Testing_Book_Ch.Ch6;
abstract class Nocturnal{
    abstract boolean isBlind();
}
public class E15_Owl extends Nocturnal {
    public boolean isBlind(){
        return false;
    }
    public static void main(String[] args){
        var nocturnal = (Nocturnal)new E15_Owl();
        System.out.println(nocturnal.isBlind());
    }
}
