package Testing_Book_Ch.Ch10;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1_Ex2_Ex16 {
    public static void main(String[] args) {

        /*
        ///////////////////////////////////////////////////////////////////////ex1
        var stream = Stream.iterate("", (s) -> s + "1");
        //System.out.println(stream.limit(2).map(x -> x + "2"));
        stream
                .limit(2)
                .map(x -> x + "2")
                .forEach(System.out::println);



        ///////////////////////////////////////////////////////////////////////ex2

        Predicate<String> predicate = s -> s.startsWith("g");
        var stream1 = Stream.generate(() -> "growl");
        var stream2 = Stream.generate(() -> "growl");
        var b1 = stream1.anyMatch(predicate);
        var b2 = stream2.allMatch(predicate);
        System.out.println(b1 + " " + b2);

         */

        ///////////////////////////////////////////////////////////////////////ex16

        Predicate<String > empty = String::isEmpty;
        Predicate<String > notEmpty = empty.negate();

        var result = Stream.generate(() -> "")
                .limit(10)
                .filter(notEmpty)
                .collect(Collectors.groupingBy(k -> k))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.partitioningBy(notEmpty));
        System.out.println(result);
    }
}
