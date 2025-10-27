package Testing_Book_Ch.Ch8;

public class TestSecret_ex4 {
    public static void main(String[] args) {
        //Secret s = new MySecret();
        //Secret s = (e) -> "Poof";
        //Secret s = (e) -> { String e = ""; "Poof" };
        //Secret s = (e) -> { String e = ""; return "Poof"; };
        Secret s =(e) -> { String f = ""; return "Poof"; };
        System.out.println(s.magic(4.5));
    }
}