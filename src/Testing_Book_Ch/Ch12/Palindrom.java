package Testing_Book_Ch.Ch12;

import java.text.Normalizer;
import java.util.*;
import java.util.stream.IntStream;

public class Palindrom {


    static String normalizeStr(String s) {
        if (s == null)
            throw new NullPointerException("String is null");

        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : lower.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static boolean isPalindromBasic(String str) {
        try {
            String clean = normalizeStr(str);
            String reversed = new StringBuilder(clean).reverse().toString();
            return clean.equals(reversed);
        }catch(NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean isPalindromStream(String str) {
        try {
            String t = normalizeStr(str);
            int n = t.length();
            return IntStream.range(0, n / 2)
                    .allMatch(i -> t.charAt(i) == t.charAt(n - 1 - i));
        } catch (NullPointerException e) {
            System.out.println("Eroare: " + e.getMessage());
            return false;
        }
    }

    static Optional<String> longestPalindrome(List<String> items) {
        if(items.isEmpty())
            return Optional.empty();
        return items.stream()
                .filter(Objects::nonNull)
                .filter(Palindrom::isPalindromBasic)
                .max(Comparator.comparingInt(s ->normalizeStr(s).length()));
    }

    public static void main(String[] args) {
        List<String>  test = new ArrayList<>(Arrays.asList("Ana", "radaR", "abracadabra","no melon", "Java", "12321", null, ""));

        for (String s : test) {
            boolean result = isPalindromStream(s);
            System.out.println("Text: " + s + "  --->  Palindrom: " + (result ? "DA" : "NU"));
        }

        Optional<String> longest = longestPalindrome(test);
        System.out.println("Cel mai lung palindrom: " + (longest.isPresent() ? "\"" + longest.get() + "\"" : "Nothing find"));
    }
}
