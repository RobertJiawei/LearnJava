package LearnArray;

//The scoring range for judges in a singing competition is from 0 to 100. The final score for a contestant is calculated by removing the highest and lowest scores, and then dividing the sum of the remaining scores by the number of judges.

import java.util.Scanner;

public class practice3 {
    public static void main(String[] args) {
        int[] scores = getScore();
        int max = getMax(scores);
        int min = getMin(scores);
        double result = getFinalScore(scores, max, min);
        System.out.println(result);
    }

    public static int[] getScore() {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[6];

        for (int i = 0; i < 6; ) {
            System.out.println("Please enter judge's given score");
            int score = sc.nextInt();
            if (score >= 0 && score <= 100) {
                scores[i] = score;
                i++;
            } else {
                System.out.println("Please re-enter the score. score must between 0 and 100");
            }
        }

        return scores;
    }

    public static int getMax(int[] scores) {
        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public static int getMin(int[] scores) {
        int min = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    public static double getFinalScore(int[] scores, int max, int min) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return (double) (sum - max - min) / (scores.length - 2);
    }
}
