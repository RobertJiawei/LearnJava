package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {
        //p1();
        //p2();
        //p3();
        p4();
    }

    private static void p1() {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "abc-male-12", "cvs-male-234", "sadf-male-44", "asdf-female-23", "aa-female-65", "ewr-male-64", "dgh-female-123");

        // using stream collect all male in the list to a new list
        List<String> newList1 = list.stream().filter(s -> "male".equals(s.split("-")[1])).toList();
        System.out.println(newList1);

        // using stream collect all male in the list to a new set
        Set<String> newSet = list.stream().filter(s -> "male".equals(s.split("-")[1])).collect(Collectors.toSet());
        System.out.println(newSet);

        // using stream collect all male in the list to a map where name is the key and age is the value
        Map<String, Integer> newMap = list.stream().filter(s -> "male".equals(s.split("-")[1])).collect(Collectors.toMap(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.split("-")[0];
            }
        }, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[2]);
            }
        }));
        System.out.println(newMap);
    }

    private static void p2() {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Set<Integer> newSet = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toSet());
        System.out.println(newSet);
    }

    private static void p3() {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "zhangsan, 23", "lisi, 24", "wangwu, 25");

        // get people whose age is greater than 24, then store the data to a map where name is the key and age is the value

        Map<String, Integer> newMap = list.stream()
                .filter(s -> Integer.parseInt(s.split(", ")[1]) >= 24)
                .collect(Collectors.toMap(
                        s -> s.split(", ")[0],
                        s -> Integer.parseInt(s.split(", ")[1])
                ));
        System.out.println(newMap);
    }

    private static void p4() {
        ArrayList<String> maleActor = new ArrayList<>();
        ArrayList<String> femaleActor = new ArrayList<>();

        Collections.addAll(maleActor, "abc,24", "qwer,21", "afa,29", "asdf,25", "qwe,21", "ccc,22");
        Collections.addAll(femaleActor, "z,23", "q,19", "s,21", "f,24");

        Stream<String> male = maleActor.stream()
                .filter(s -> s.split(",")[0].length() == 3)
                .limit(3);
        Stream<String> female = femaleActor.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) > 20).skip(1);

        List<Actor> newList = Stream.concat(male, female)
                .map(s -> new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1])))
                .toList();

        System.out.println(newList);
    }
}
