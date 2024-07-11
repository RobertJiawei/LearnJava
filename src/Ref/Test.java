package Ref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Collections.addAll(list, new Student("zhangsan", 23), new Student("lisi", 24), new Student("wangwu", 28));

        String[] str = list.stream().map(Student::getName).toArray(String[]::new);

        System.out.println(Arrays.toString(str));
    }
}
