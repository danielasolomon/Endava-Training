package Testing_Book_Ch.Ch6;

public class Ex18_Mammal {
    private void eat() {}
    protected static void drink() {}
    public Integer dance(String p) {
        return null;
    }
}

class Primate extends Ex18_Mammal {
    public void eat(String p) {}
}

class Monkey extends Primate {
    protected static void drink() throws RuntimeException {}
    public Number dance(CharSequence p) {
        return null;
    }
   // public int eat(String p) {}
}
