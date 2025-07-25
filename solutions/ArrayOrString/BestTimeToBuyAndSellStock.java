package solutions.ArrayOrString;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int[] diffs = new int[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            diffs[i-1] = prices[i] - prices[i-1];
        }

        int bestSum = -10000, currentSum = 0;
        for (int diff : diffs) {
            currentSum = max(diff, currentSum + diff);
            bestSum = max(bestSum, currentSum);
        }

        if (bestSum < 0) bestSum = 0;
        return bestSum;
    }

    private static void showcase(List<int[]> nums) {
        for (int[] num : nums) {
            System.out.printf("profit: %d, array: %s%n", maxProfit(num), Arrays.toString(num));
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        List<int[]> testcases = List.of(
                new int[]{7, 1, 5, 3, 6, 4},
                new int[]{7, 6, 4, 3, 1},
                new int[]{2, 4, 1},
                new int[]{1, 2, 3, 4, 5, 6}
        );

        showcase(testcases);
    }
}
