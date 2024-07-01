package LearnArray;

//random generate a verify code. code format is 4 letters plus a number.

import java.util.Arrays;

public class practice1 {
    public static void main(String[] args) {
        char[] chs = new char[52];

        for (int i = 0; i < chs.length; i++) {
            if (i <= 25) {
                chs[i] = (char) (97 + i); //from 'a' to 'z'
            } else {
                chs[i] = (char) (65 + i - 26); //from 'A' to 'Z'
            }
        }
    }
}
