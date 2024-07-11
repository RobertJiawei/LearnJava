package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Practice1 {
    public static void main(String[] args) {
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
}
