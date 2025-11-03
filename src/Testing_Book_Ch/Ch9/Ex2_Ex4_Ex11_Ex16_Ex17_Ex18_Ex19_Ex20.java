package Testing_Book_Ch.Ch9;

import java.util.*;

public class Ex2_Ex4_Ex11_Ex16_Ex17_Ex18_Ex19_Ex20 {
    public static void main(String[] args) {
        /*
        ///////////////////////////////////////////////////////ex2

        List<?> q = new ArrayList<>(
                List.of(1, 2, 3, 4, 5)
        );

        var aa = List.of("mouse", "dog", "cat");

        aa.removeIf(String::isEmpty);
        aa.removeIf(s -> s.length() == 4);


        ////////////////////////////////////////////////////////ex4

        //HashSet<Number> hs = new HashSet<Integer>();
        HashSet<Number> hs = new HashSet<Number>();

        HashSet<? super ClassCastException> set = new HashSet<Exception>();

        //List<> list = new ArrayList<String>();
        List<String> list = new ArrayList<String>();

        //List<Object> values = new HashSet<Object>();
        HashSet<Object> values = new HashSet<Object>();


        //List<Object> objects = new ArrayList<? extends Object>();
        List<? extends Object> objects = new ArrayList<Object>();

        Map<String, ? extends Number> hm = new HashMap<String, Integer>();

        //////////////////////////////////////////////////////////////////ex 11



        var list1 = List.of(1, 2, 3);
        var set1 = Set.of(1, 2, 3);
        var map1 = Map.of(1, 2, 3, 4);

        list1.forEach(System.out::println);
        set1.forEach(System.out::println);
        map1.keySet().forEach(System.out::println);
        map1.values().forEach(System.out::println);



        ////////////////////////////////////////////ex 16
        //List<Integer> q = new LinkedList<>();
        var q = new LinkedList<>();
        var u = Collections.unmodifiableList(q);
        q.add(10);
        q.add(12);
        q.remove(1);
        System.out.println(u);

        //////////////////////////////////////////////////////ex17

        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        System.out.println(m.containsKey(123));

        //////////////////////////////////////////////////////ex18

        var map = Map.of(1,2,3,6);
        var list = List.copyOf(map.entrySet());

        List<Integer> one = List.of(8,16,2);
        var copy = List.copyOf(one);
        var copyOfCopy = List.copyOf(copy);
        var thirdCopy = new ArrayList<>(copyOfCopy);

        //list.replaceAll(x -> x * 2);
        one.replaceAll(x -> x * 2);
        thirdCopy.replaceAll(x -> x * 2);

        System.out.println(thirdCopy);
        */


        ////////////////////////////////////////ex20

        var map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, null);
        map.merge(1, 3, (a,b) -> a - b);
        map.merge(3, 2, (a,b) -> a + b);
        map.merge(4, 9, (a,b) -> a - b);
        System.out.println(map);


    }
    ////////////////////////////////////////ex19
    public static<T> T identity(T t){
        return t;
    }
}
