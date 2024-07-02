package LearnString;

import com.sun.security.jgss.GSSUtil;

public class practice2 {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "cdeab";

        System.out.println(check(str1, str2));
    }

    public static String rotateString(String str) {
        char left = str.charAt(0);
        String remain = str.substring(1);
        return remain + left;
    }

    public static boolean check(String str1, String str2) {
        int count = 0;

        if (str1.length() != str2.length()) return false;
        while (count < str1.length()) {
            str1 = rotateString(str1);
            if (str1.equals(str2)) {
                System.out.println("String match after rotate " + (count + 1) + " times");
                return true;
            } else {
                count++;
            }
        }

        if (count == str1.length()) System.out.println("String does not match");
        return false;
    }
}
