package Testing_Book_Ch.Ch7;

public interface Ex24_BigCat {
    static String getName() {
        return null;
    }

    static int hunt(){
        getName();
        return 5;
    }
    static void climb(){
        rest();
    }
    private static void roar(){
        getName();
        climb();
        hunt();
    }
    private static boolean sneak(){
        roar();
        return true;
    }

    private static int rest(){
        return 2;
    }

}
