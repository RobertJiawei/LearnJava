package Regex;

// use regex to check if phone number and email follow rules.

public class Practice1 {
    public static void main(String[] args) {
        String number = "13434534543";
        String email = "123123@gmail.com";

        String regex1 = "1[3-9]\\d{9}";
        System.out.println(number.matches(regex1));
    }
}
