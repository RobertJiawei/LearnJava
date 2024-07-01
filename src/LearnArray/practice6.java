package LearnArray;

// two color ball lotta game. red ball's number from 1-33, blue ball's number from 1-16. win condition: 1. 6 red + 1 blue; 2. 6 red; 3. 5 red + 1 blue; 4. 5 red; 5. 4 red + 1 blue; 6. 4 red; 7. 3 red + 1 blue; 8. 3 red;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class practice6 {
    public static void main(String[] args) {
        int[] win = winNumber();
        System.out.println(Arrays.toString(win));
        int[] chooseNumbers = chooseNumber();
        System.out.println(Arrays.toString(chooseNumbers));
        int[] result = checkWin(win, chooseNumbers);
        System.out.println(Arrays.toString(result));
    }

    public static int[] winNumber() {
        int[] arr = new int[7];

        // get red ball numbers
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int number = r.nextInt(1, 34);
            if (isNotIn(arr, number)) {
                arr[i] = number;
                i++;
            }
        }

        // get blue ball numbers
        arr[6] = r.nextInt(1, 17);
        return arr;
    }

    public static boolean isNotIn(int[] arr, int number) {
        for (int j : arr) {
            if (number == j) {
                return false;
            }
        }
        return true;
    }

    public static int[] chooseNumber() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[7];

        for (int i = 0; i < 6; ) {
            System.out.println("enter red ball number");
            int number = sc.nextInt();
            if (number > 0 && number < 34) {
                if (isNotIn(numbers, number)) {
                    numbers[i] = number;
                    i++;
                } else {
                    System.out.println("number ready chose!");
                }
            } else {
                System.out.println("number chose is out of range!");
            }
        }
        System.out.println("enter blue ball number");
        int blueNumber = sc.nextInt();
        while (blueNumber < 0 || blueNumber > 16) {
            System.out.println("please re-enter the number");
            blueNumber = sc.nextInt();
        }
        numbers[6] = blueNumber;

        return numbers;
    }

    public static int[] checkWin(int[] winArr, int[] chooseArr) {
        int redCount = 0;
        int blueCount = 0;

        for (int i = 0; i < chooseArr.length - 1; i++) {
            for (int j = 0; j < winArr.length - 1; j++) {
                if (chooseArr[i] == winArr[j]) {
                    redCount++;
                }
            }
        }

        if (winArr[6] == chooseArr[6]) blueCount++;

        return new int[]{redCount, blueCount};
    }
}
