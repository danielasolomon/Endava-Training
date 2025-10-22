package Testing_Book_Ch;
public class test1{
    enum Flavors{
        VANILLA,CHOCOLATE,STRAWBERRY;
        private Flavors(){}
    }
    public static void main(String[] args) {
        for(final var e: Flavors.values())
        {
            System.out.println((e.ordinal()%2) +" ");
        }
    }
}

