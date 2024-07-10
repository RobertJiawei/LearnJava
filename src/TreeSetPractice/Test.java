package TreeSetPractice;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student(23, 60, 70, 90, "zhanshan");
        Student s2 = new Student(22, 60, 90, 40, "zhaosi");
        Student s3 = new Student(25, 50, 70, 70, "wangwu");
        Student s4 = new Student(21, 30, 10, 80, "zhaoliu");

        TreeSet<Student> ts = new TreeSet<>();

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);


        System.out.println(ts);
    }
}
