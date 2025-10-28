package Testing_Book_Ch.Ch7;

public class Ex19_Bear {
    enum FOOD {
        BERRIES, INSECTS {
            public boolean isHealthy() {
                return true;
            }
        },
        FISH, ROOTS, COOKIES, HONEY;

        public boolean isHealthy() {
            return true;
        }

    }

    public static void main(String[] args) {
        System.out.println(FOOD.ROOTS.ordinal());
        System.out.println(FOOD.INSECTS.ordinal());
        System.out.println(FOOD.INSECTS.isHealthy());
        System.out.println(FOOD.COOKIES.isHealthy());
    }
}
