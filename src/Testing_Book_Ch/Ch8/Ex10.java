package Testing_Book_Ch.Ch8;

import java.util.List;
import java.util.function.Predicate;

public class Ex10 {

    public void  remove(List<Character> chars){

        char end = 'z';

        Predicate<Character> predicate = c -> {
            char start = 'a';
            return start <= c && c<= end;
        };

        char start = 'a';
        char c = 'x';
        chars = null;
       // end = '1';
    }
}
