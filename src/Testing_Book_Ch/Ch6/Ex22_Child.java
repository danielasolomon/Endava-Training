package Testing_Book_Ch.Ch6;

class Person {
    static String name;

    void setName(String q) {
        name = q;
    }
}

public class Ex22_Child extends Person {
    static String name;

    void setName(String w) {
        name = w;
    }

    public static void main(String[] args) {
        final Ex22_Child m = new Ex22_Child();
        final Person t = m;
        m.name = "Elysa";
        t.name = "Sophia";
        m.setName("Webby");
        t.setName("Olivia");
        System.out.println(m.name + " " + t.name);
    }
}
