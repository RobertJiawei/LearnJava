package LearnString;

import java.util.Objects;

public class practice3 {
    public static void main(String[] args) {
        String str = "Hello ";
        System.out.println(getLength(str));
    }

    public static int getLength(String str) {
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') return count;
            count++;
        }
        return count;
    }
}
