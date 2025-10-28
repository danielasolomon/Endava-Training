package Testing_Book_Ch.Ch6;

import java.util.List;

class Reptile {
     {
        System.out.println("A");
    }

    public Reptile(int hatch) {
    }

    void layEggs() {
        System.out.println("Reptile");
    }
}

public class Ex19_Lizard extends Reptile {
    static {
        System.out.println("B");
    }

    //public Ex19_Lizard(int hatch){}
    public Ex19_Lizard(int hatch) {
        super(hatch);
    }

    @Override
    public final void layEggs() {
        System.out.println("Lizard");
    }

    public static void main(String[] args) {
        var reptile = new Ex19_Lizard(1);
        reptile.layEggs();
    }
}
