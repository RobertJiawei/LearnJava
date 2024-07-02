package LearnArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        //pt1();
        //pt2();
        //pt3();
        //pt4();
        pt5();
    }

    public static void pt1() {
        ArrayList<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void pt2() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void pt3() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("enter name: ");
            String name = sc.next();
            System.out.println("enter age: ");
            int age = sc.nextInt();
            list.add(new Student(name, age));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }

    public static void pt4() {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        list.add(new User("heima001", "zhansan", "abc"));
        list.add(new User("heima002", "lisi", "abc"));
        list.add(new User("heima003", "wangwu", "abc"));

        System.out.println("enter userId");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                System.out.println("found user " + list.get(i) + "\nthis user's index of arraylist is " + i);
                break;
            }
        }
    }

    public static void pt5() {
        ArrayList<Phone> list = new ArrayList<>();
        ArrayList<Phone> resultList = new ArrayList<>();

        list.add(new Phone("xiaomi", 1000));
        list.add(new Phone("apple", 8999));
        list.add(new Phone("chuizi", 2999));

        for (int i = 0; i < list.size(); i++) {
            Phone p = list.get(i);
            if (p.getPrice() < 3000) {
                resultList.add(p);
            }
        }

        for (int i = 0; i < resultList.size(); i++) {
            Phone p = resultList.get(i);
            System.out.println(p.getBrand());
        }
    }
}
