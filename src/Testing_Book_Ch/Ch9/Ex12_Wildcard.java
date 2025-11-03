package Testing_Book_Ch.Ch9;

import java.util.*;

public class Ex12_Wildcard {
    public void showSize(List<?> list){
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        Ex12_Wildcard card = new Ex12_Wildcard();
        //ArrayList<? super Date> list = new ArrayList<Date>();
        ArrayList<? extends Number> list = new ArrayList<Integer>();
        card.showSize(list);    
    }
}
