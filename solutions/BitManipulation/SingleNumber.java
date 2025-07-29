package solutions.BitManipulation;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
            System.out.println(res);
        }

        return res;
    }

    public static void showcase(List<int[]> testcases) {
        for (int[] testcase : testcases) {
            System.out.printf("single number: %d, nums: %s\n", singleNumber(testcase), Arrays.toString(testcase));
        }
    }

    public static void main(String[] args) {
        List<int[]> testcases = List.of(
                new int[]{2, 2, 1},
                new int[]{4, 1, 2, 1, 2},
                new int[]{1}
        );

        showcase(testcases);
    }
}
