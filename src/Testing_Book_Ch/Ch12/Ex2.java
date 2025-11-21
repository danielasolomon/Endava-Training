package Testing_Book_Ch.Ch12;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Ex2{

    /* =========================
       1) STRING / TEXT
       ========================= */

    // Palindrom (normalize + mirror check, O(n))
    static String normalize(String s) {
        if (s == null) throw new IllegalArgumentException("text null");
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
        }
        return sb.toString();
    }
    static boolean isPalindrome(String s) {
        try {
            String t = normalize(s);
            int n = t.length();
            return IntStream.range(0, n/2).allMatch(i -> t.charAt(i) == t.charAt(n-1-i));
        } catch (IllegalArgumentException e) { return false; }
    }

    // Anagramă (groupingBy + counting)
    static boolean isAnagram(String a, String b) {
        return freqByGrouping(a).equals(freqByGrouping(b));
    }
    static Map<Character, Long> freqByGrouping(String s) {
        String t = normalize(s);
        return t.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // Numără vocale/consoane
    static Map<String, Long> countVowelsConsonants(String s) {
        String t = normalize(s);
        long vowels = t.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
        long consonants = t.length() - vowels;
        return Map.of("vowels", vowels, "consonants", consonants);
    }

    // Inversează fiecare cuvânt din propoziție
    static String reverseEachWord(String sentence) {
        if (sentence == null) throw new IllegalArgumentException("text null");
        return Arrays.stream(sentence.split("\\s+"))
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    // Elimină duplicatele de caractere menținând ordinea
    static String dedupChars(String s) {
        if (s == null) throw new IllegalArgumentException("text null");
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) if (seen.add(c)) sb.append(c);
        return sb.toString();
    }

    // Pangram (conține toate literele a..z)
    static boolean isPangram(String s) {
        String t = s == null ? "" : s.toLowerCase();
        long distinctLetters = t.chars().filter(Character::isLetter).distinct().count();
        return distinctLetters >= 26;
    }


    /* =========================
       2) COLECȚII / STREAM API
       ========================= */

    // Max/Min din listă
    static Optional<Integer> maxOf(List<Integer> list) {
        return list == null ? Optional.empty() : list.stream().max(Integer::compareTo);
    }
    static Optional<Integer> minOf(List<Integer> list) {
        return list == null ? Optional.empty() : list.stream().min(Integer::compareTo);
    }

    // Sortare pe mai multe criterii (nume, apoi vârstă)
    record Person(String name, int age) {}
    static List<Person> sortPersons(List<Person> people) {
        if (people == null) return List.of();
        return people.stream()
                .sorted(Comparator.comparing(Person::name).thenComparing(Person::age))
                .toList();
    }

    // Grupare după prima literă
    static Map<Character, List<String>> groupByFirstLetter(List<String> words) {
        if (words == null) return Map.of();
        return words.stream()
                .filter(Objects::nonNull)
                .filter(w -> !w.isEmpty())
                .collect(Collectors.groupingBy(w -> Character.toLowerCase(w.charAt(0))));
    }

    // Numără apariții cuvinte într-un text
    static Map<String, Long> wordCount(String text) {
        if (text == null || text.isBlank()) return Map.of();
        return Arrays.stream(text.toLowerCase().split("\\W+"))
                .filter(w -> !w.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // Filtrează + transformă (peste 18 ani -> nume uppercase)
    static List<String> adultsUpper(List<Person> people) {
        if (people == null) return List.of();
        return people.stream().filter(p -> p.age() >= 18).map(p -> p.name().toUpperCase()).toList();
    }


    /* =========================
       3) OPTIONAL / EXCEPȚII
       ========================= */

    // Caută un element și întoarce Optional
    static Optional<String> findFirstStartingWith(List<String> list, String prefix) {
        if (list == null || prefix == null) return Optional.empty();
        return list.stream().filter(Objects::nonNull).filter(s -> s.startsWith(prefix)).findFirst();
    }

    // Excepție custom + validare
    static class InvalidInputException extends RuntimeException {
        InvalidInputException(String msg) { super(msg); }
    }
    static int parsePositiveInt(String s) {
        try {
            int v = Integer.parseInt(s);
            if (v <= 0) throw new InvalidInputException("număr ne-pozitiv: " + v);
            return v;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("nu este număr întreg: " + s);
        }
    }


    /* =========================
       4) FUNCȚIONALE / LAMBDA
       ========================= */

    // Filtrare cu Predicate
    static <T> List<T> filter(List<T> data, Predicate<T> p) {
        if (data == null) return List.of();
        return data.stream().filter(p).toList();
    }

    // Consumer pentru afișare
    static <T> void forEachPrint(List<T> data, Consumer<T> c) {
        if (data != null) data.forEach(c);
    }

    // Compoziție de Function
    static String trimUpper(String s) {
        Function<String, String> trim = String::trim;
        Function<String, String> upper = String::toUpperCase;
        return trim.andThen(upper).apply(s);
    }

    // Supplier listă random
    static List<Integer> randomList(int n, int bound) {
        Supplier<Integer> rnd = () -> new Random().nextInt(bound);
        return IntStream.range(0, n).map(i -> rnd.get()).boxed().toList();
    }


    /* =========================
       5) RECORDS / SEALED
       ========================= */

    // Record deja definit: Person(name, age)

    // Sealed hierarchy
    sealed interface Shape permits Circle, Square {}
    static final class Circle implements Shape { final double r; Circle(double r){this.r=r;} }
    static final class Square implements Shape { final double a; Square(double a){this.a=a;} }

    // Arie simplă cu pattern matching switch (doar demo)
    static double area(Shape s) {
        return switch (s) {
            case Circle c -> Math.PI * c.r * c.r;
            case Square sq -> sq.a * sq.a;
        };
    }


    /* =========================
       6) PATTERN MATCHING / SWITCH
       ========================= */

    static String typeOf(Object o) {
        return switch (o) {
            case Integer i -> "număr: " + i;
            case String s when s.length() > 3 -> "text mare: " + s;
            case String s -> "text scurt: " + s;
            case null -> "null";
            default -> "altceva";
        };
    }

    static void instanceofDemo(Object obj) {
        if (obj instanceof String s && s.contains("Java")) {
            System.out.println("Conține 'Java': " + s);
        } else {
            System.out.println("Nu e String cu 'Java': " + obj);
        }
    }


    /* =========================
       7) NUMERE / LISTE NUMERICE
       ========================= */

    static boolean isPrime(int n) {
        if (n < 2) return false;
        int limit = (int)Math.sqrt(n);
        return IntStream.rangeClosed(2, limit).noneMatch(d -> n % d == 0);
    }

    static int sumOfEvens(List<Integer> nums) {
        if (nums == null) return 0;
        return nums.stream().filter(Objects::nonNull).filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    static OptionalDouble average(List<Integer> nums) {
        if (nums == null) return OptionalDouble.empty();
        return nums.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).average();
    }

    static Optional<Integer> smallestPositive(List<Integer> nums) {
        if (nums == null) return Optional.empty();
        return nums.stream().filter(Objects::nonNull).filter(i -> i > 0).min(Integer::compareTo);
    }


    /* =========================
       8) MAP / TRANSFORMĂRI
       ========================= */

    // Map: string -> lungime
    static Map<String, Integer> toLengthMap(List<String> list) {
        if (list == null) return Map.of();
        return list.stream().filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), String::length, (a,b)->a, LinkedHashMap::new));
    }

    // Filtrează intrările cu valoare pară
    static Map<String, Integer> filterEvenValues(Map<String, Integer> map) {
        if (map == null) return Map.of();
        return map.entrySet().stream()
                .filter(e -> e.getValue() != null && e.getValue() % 2 == 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // Inversează map (valoare -> chei concatenate), rezolvă coliziuni
    static Map<Integer, String> invertMap(Map<String, Integer> map) {
        if (map == null) return Map.of();
        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getValue,
                        Map.Entry::getKey,
                        (a, b) -> a + "," + b
                ));
    }


    /* =========================
       DEMO
       ========================= */
    public static void main(String[] args) {

        // 1) STRING
        System.out.println("Palindrom: " + isPalindrome("No lemon, no melon"));
        System.out.println("Anagrama: " + isAnagram("Listen", "Silent"));
        System.out.println("Vocale/Consoane: " + countVowelsConsonants("Java Stream API"));
        System.out.println("Reverse fiecare cuvânt: " + reverseEachWord("Java este tare"));
        System.out.println("Dedup chars 'banana' -> " + dedupChars("banana"));
        System.out.println("Pangram: " + isPangram("The quick brown fox jumps over a lazy dog"));

        // 2) COLECȚII
        List<Integer> nums = Arrays.asList(5, 1, 8, 2, 2, 9);
        System.out.println("Max: " + maxOf(nums));
        System.out.println("Min: " + minOf(nums));
        List<Person> people = List.of(new Person("Ana", 25), new Person("Bob", 17), new Person("Ana", 19));
        System.out.println("Sort persons: " + sortPersons(people));
        System.out.println("Group by first: " + groupByFirstLetter(List.of("Java", "JavaScript", "Kotlin", "Python")));
        System.out.println("Word count: " + wordCount("Ana are are mere, ana are pere"));
        System.out.println("Adults upper: " + adultsUpper(people));

        // 3) OPTIONAL / EXCEPȚII
        System.out.println("Find startsWith 'Ja': " + findFirstStartingWith(List.of("C", "Ja", "Ruby"), "Ja"));
        try { System.out.println("Parse positive: " + parsePositiveInt("42")); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { System.out.println("Parse positive: " + parsePositiveInt("-3")); } catch (Exception e) { System.out.println(e.getMessage()); }

        // 4) FUNCȚIONALE
        System.out.println("Filter >3: " + filter(nums, n -> n > 3));
        System.out.print("forEachPrint: "); forEachPrint(List.of("A","B","C"), x -> System.out.print(x + " ")); System.out.println();
        System.out.println("trimUpper: " + trimUpper("   hello  "));
        System.out.println("randomList: " + randomList(5, 10));

        // 5) SEALED / RECORD / AREA
        Shape s1 = new Circle(2.0); Shape s2 = new Square(3.0);
        System.out.println("Area circle: " + area(s1) + " | square: " + area(s2));

        // 6) PATTERN MATCHING
        System.out.println("typeOf(10) -> " + typeOf(10));
        System.out.println("typeOf(\"abc\") -> " + typeOf("abc"));
        System.out.println("typeOf(\"hello world\") -> " + typeOf("hello world"));
        instanceofDemo("I love Java"); instanceofDemo(123);

        // 7) NUMERE
        System.out.println("isPrime(29): " + isPrime(29));
        System.out.println("sumOfEvens: " + sumOfEvens(nums));
        System.out.println("average: " + (average(nums).isPresent() ? average(nums).getAsDouble() : "n/a"));
        System.out.println("smallestPositive: " + smallestPositive(Arrays.asList(-5, 0, 3, 1, 2)));

        // 8) MAP
        Map<String, Integer> lens = toLengthMap(List.of("ana","are","mere"));
        System.out.println("toLengthMap: " + lens);
        System.out.println("filterEvenValues: " + filterEvenValues(lens));
        System.out.println("invertMap: " + invertMap(lens));
    }
}
