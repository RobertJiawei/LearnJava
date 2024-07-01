package LearnArray;

// Encrypt a passcode. Encrypt rule is: first, get each digit and plus 5 to each digit. second get the remaining after mod 10. last revers each digit.

import java.util.Arrays;
import java.util.Scanner;

public class practice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int passcode = sc.nextInt();
        int[] passcodeArr = intToArray(passcode);
        int[] encryptPasscodeArr = encrypt(passcodeArr);
        int[] decryptPasscodeArr = decrypt(encryptPasscodeArr);
        int result = arrayToInt(decryptPasscodeArr);
        System.out.println(result);
    }

    public static int[] intToArray(int passcode) {
        int number = passcode;
        int digit = 0;
        while (passcode != 0) {
            passcode /= 10;
            digit++;
        }
        int[] passcodeArr = new int[digit];
        for (int i = digit - 1; i >= 0; i--) {
            int d = number % 10;
            number /= 10;
            passcodeArr[i] = d;
        }
        return passcodeArr;
    }

    public static int arrayToInt(int[] array) {
        int number = 0;
        for (int j : array) {
            number = number * 10 + j;
        }
        return number;
    }

    public static int[] encrypt(int[] passcode) {
        for (int i = 0; i < passcode.length; i++) {
            passcode[i] += 5;
        }

        for (int i = 0; i < passcode.length; i++) {
            passcode[i] %= 10;
        }

        for (int i = 0, j = passcode.length - 1; i < j; i++, j--) {
            int temp = passcode[i];
            passcode[i] = passcode[j];
            passcode[j] = temp;
        }

        return passcode;
    }

    public static int[] decrypt(int[] passcode) {
        for (int i = 0, j = passcode.length - 1; i < j; i++, j--) {
            int temp = passcode[i];
            passcode[i] = passcode[j];
            passcode[j] = temp;
        }

        for (int i = 0; i < passcode.length; i++) {
            if (passcode[i] < 5 || passcode[i] > 9) {
                passcode[i] += 10;
            }
        }

        for (int i = 0; i < passcode.length; i++) {
            passcode[i] -= 5;
        }

        return passcode;
    }
}
