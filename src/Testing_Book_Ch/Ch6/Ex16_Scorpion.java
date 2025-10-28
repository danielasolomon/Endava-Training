package Testing_Book_Ch.Ch6;
class Arachind{
    static StringBuilder sb = new StringBuilder();
    {sb.append("c");}
    static {sb.append("u");}
    {sb.append("r");}
}
public class Ex16_Scorpion extends  Arachind {
    static {sb.append("q");}
    {sb.append("m");}

    public static void main(String[] args) {
        System.out.println(Ex16_Scorpion.sb + " ");
        System.out.println(Ex16_Scorpion.sb + " ");
        new Arachind();
        new Ex16_Scorpion();
        System.out.println(Ex16_Scorpion.sb);
    }
}
