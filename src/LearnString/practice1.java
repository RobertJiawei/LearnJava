package LearnString;

import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            System.out.println("please enter");
            String str = sc.next();
            if (checkStr(str)) {
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    int number = c - 48;
                    sb.append(convertToRoma(number)).append(" ");
                }
                break;
            } else {
                System.out.println("String not accept!");
            }
        }

        System.out.println(sb.toString());
    }

    public static boolean checkStr(String str) {
        if (str.length() > 9) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static String convertToRoma(int number) {
        String[] arr = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return arr[number];
    }
}
