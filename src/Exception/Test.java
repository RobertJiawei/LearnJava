package Exception;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GirlFriend gl = new GirlFriend();

        while (true) {
            try {
                System.out.println("enter name:");
                String name = sc.nextLine();
                gl.setName(name);
                System.out.println("enter age");
                int age = Integer.parseInt(sc.nextLine());
                gl.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("age format error");
            } catch (RuntimeException e) {
                System.out.println("name length or range error");
            }
        }
        System.out.println(gl);
    }
}
