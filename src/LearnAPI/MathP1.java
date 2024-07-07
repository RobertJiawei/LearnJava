package LearnAPI;

public class MathP1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            if (check(i)) {
                System.out.println(i);
                count++;
            }
            ;
        }

        if (count == 0) System.out.println("No number qualify");
    }

    public static boolean check(int num) {
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100 % 10;
        int result = (int) (Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3));
        return result == num;
    }
}
