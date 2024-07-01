package LearnArray;

// lotte game, lotte has [2, 588, 888, 1000, 10000] prize. make a program to simulate this lotte game. print each prize and make sure each prize only shows once.

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class practice5 {
    public static void main(String[] args) {
        int[] prize = {2, 588, 888, 1000, 10000};
        int[] newPrize = new int[prize.length];

        Random r = new Random();

        for (int i = 0; i < prize.length; ) {
            int number = prize[r.nextInt(prize.length)];
            if (!isIn(newPrize, number)) {
                newPrize[i] = number;
                i++;
            }
        }
        System.out.println(Arrays.toString(newPrize));
    }

    public static boolean isIn(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                return true;
            }
        }
        return false;
    }
}
