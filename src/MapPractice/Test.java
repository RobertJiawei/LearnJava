package MapPractice;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //p1();
        //p2();
        //p3();
        p4();
    }

    private static void p1() {
        HashMap<Student, String> m = new HashMap<>();

        Student s1 = new Student(18, "zhangsan");
        Student s2 = new Student(20, "zhaosi");
        Student s3 = new Student(25, "wangwu");

        m.put(s1, "jiangsu");
        m.put(s2, "guangdong");
        m.put(s3, "shanghai");

        Set<Student> keys = m.keySet();
        for (Student key : keys) {
            String value = m.get(key);
            System.out.println(key + " from " + value);
        }

        System.out.println("-------------------");

        Set<Map.Entry<Student, String>> entries = m.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        System.out.println("--------------------");

        m.forEach((student, value) -> System.out.println(student + value));
    }

    private static void p2() {
        String[] arr = {"A", "B", "C", "D"};
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 80; i++) {
            list.add(arr[r.nextInt(arr.length)]);
        }

        HashMap<String, Integer> m = new HashMap<>();
        for (String s : list) {
            if (m.containsKey(s)) {
                int count = m.get(s);
                count++;
                m.put(s, count);
            } else {
                m.put(s, 1);
            }
        }

        System.out.println(m);
        int max = 0;
        Set<Map.Entry<String, Integer>> entries = m.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if (count > max) max = count;
        }
        System.out.println(max);

        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == max) System.out.println(entry.getKey());
        }
    }

    private static void p3() {
        TreeMap<Integer, String> tm = new TreeMap<>((o1, o2) -> o2 - o1);
        tm.comparator();
        tm.put(1, "a");
        tm.put(9, "a");
        tm.put(5, "c");
        tm.put(2, "a");

        System.out.println(tm);
    }

    private static void p4() {
        TreeMap<Student, String> tm = new TreeMap<>();
        Student s3 = new Student(25, "wangwu");
        Student s1 = new Student(18, "zhangsan");
        Student s2 = new Student(20, "zhaosi");

        tm.put(s1, "jiangsu");
        tm.put(s2, "guangdong");
        tm.put(s3, "shanghai");

        System.out.println(tm);
    }
}
