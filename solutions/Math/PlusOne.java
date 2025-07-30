package solutions.Math;

import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] res = digits.clone();
        boolean isLonger = false;

        for (int i = res.length - 1; i >= 0; i--) {
            res[i] += 1;
            if (res[i] == 10) {
                res[i] = 0;
                if (i == 0) {
                    isLonger = true;
                }
            } else {
                break;
            }
        }

        int[] longRes = new int[res.length + 1];
        longRes[0] = 1;

        if (isLonger) {
            System.arraycopy(res, 0, longRes, 1, res.length);
        }

        return isLonger ? longRes : res;
    }

    public static void showcase(List<int[]> testcases) {
        for (int[] testcase : testcases) {
            System.out.printf("result: %s, nums: %s\n", Arrays.toString(plusOne(testcase)),
                    Arrays.toString(testcase));
        }
    }

    public static void main(String[] args) {
        List<int[]> testcases = List.of(
                new int[]{1, 0, 9, 9},
                new int[]{1, 2, 3},
                new int[]{4, 3, 2, 1},
                new int[]{9}
        );

        showcase(testcases);
    }
}
