package solutions.BitManipulation;

import java.util.List;

public class NumberOf1Bits {
    public static int hammingWeightReference(int n) {
        int res = 0;
        while (n != 0){
            n = (n & n - 1);
            res++;
        }
        return res;
    }

    public static int hammingWeight(int n) {
        int res = 0;

        for (int i = 32; i >= 0; i--) {
            if (n - Math.pow(2, i) >= 0) {
                n -= (int) Math.pow(2, i);
                res++;
            }
        }

        return res;
    }

    public static void showcase(List<Integer> testcases) {
        for (int testcase : testcases) {
            System.out.printf("hamming weight: %d, number: %d\n", hammingWeight(testcase), testcase);
        }
    }

    public static void main(String[] args) {
        List<Integer> testcases = List.of(
                11,
                128,
                2147483645
        );

        showcase(testcases);
    }
}
