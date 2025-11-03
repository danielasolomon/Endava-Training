package Testing_Book_Ch.Ch7;

public class Ex18_Deer {
    enum Food { APPLES, BERRIES, GRASS}
    protected static class Diet {
        private Food getFavorite() {
            return Food.BERRIES;
        }
    }
    public static void main(String[] seasons) {
       //Ex18_Deer deer = new Ex18_Deer();
       //Diet diet = deer.new Diet();
        System.out.println(switch(new Diet().getFavorite()){
            case APPLES -> "a";
            case BERRIES -> "b";
            case GRASS -> "c";
        });

    }
}
