package Testing_Book_Ch.Ch8;

import java.util.List;

interface Yawn{
    String yawn(double d, List<Integer> time);
}

class Sloth implements Yawn{
    public String yawn(double zzz, List<Integer> time){
        return "Sleep: " + zzz;
    }
}

public class Vet_ex20 {
    public static String takeNap(Yawn y){
        return y.yawn(10,null);
    }

    public static void main(String... unused) {
        //System.out.println(takeNap(new Sloth()));
        System.out.println(takeNap((r,k) -> { String g = ""; return "Sleep:"; }));
    }
}

