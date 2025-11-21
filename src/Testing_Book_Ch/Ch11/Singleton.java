package Testing_Book_Ch.Ch11;

public class Singleton {
    private static Singleton instance;
    private Singleton() {
        System.out.println("Instance created!");
    }
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("s1 == s2 => " + (s1 == s2)); // should print true
    }
}
