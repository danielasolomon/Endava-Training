package Testing_Book_Ch.Ch12;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Exercitii {
    static String normalizeStr(String s) {
        if (s == null)
            throw new IllegalArgumentException("String is null");

        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : lower.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static Map<Character, Long> toCharFrequencyGroupingBy(String s) {
        String str = normalizeStr(s);
        return str.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        Map<Character, Long> f1 = toCharFrequencyGroupingBy(str1);
        Map<Character, Long> f2 = toCharFrequencyGroupingBy(str2);
        return f1.equals(f2);
    }


    static Map<Character,Long> charFrequencyToMap(String str) {
        String s = normalizeStr(str);
        return s.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.toMap(
                        Function.identity(),  // key = ch
                        c ->1L,     //starts with 1
                        Long::sum,            //if it is repeating, then sum
                        LinkedHashMap::new    // keeps order
                ));
    }

    public static void main(String[] args) {


        System.out.println("\"Listen\" vs \"Silent\" -> " + isAnagram("Listen", "Silent"));
        System.out.println("\"Java\" vs \"avaJ?\" -> " + isAnagram("Java", "avaJ?"));
        System.out.println("\"Ana\" vs \"Naa\" -> " + isAnagram("Ana", "Naa"));
        System.out.println();


        Map<Character, Long> freq = charFrequencyToMap("No lemon, no melon");
        System.out.println("Text: " + "No lemon, no melon");
        System.out.println("F: " + freq);
        System.out.println();

    }
}
