package solutions.BitManipulation;

import java.util.List;

public class ReverseBits {
    public static int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        int res = 0;

        for (int i = 32; i >= 0; i--) {
            if (n - Math.pow(2, i) >= 0) {
                n -= (int) Math.pow(2, i);
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        sb.reverse();

        for (int i = 0; i < 33; i++) {
            if (sb.charAt(i) == '1') {
                res += (int) Math.pow(2, 31 - i);
            }
        }

        return res;
    }

    public static void showcase(List<Integer> testcases) {
        for (int testcase : testcases) {
            System.out.printf("reversed number: %d, original number: %d\n", reverseBits(testcase), testcase);
        }
    }

    public static void main(String[] args) {
        List<Integer> testcases = List.of(
                43261596,
                2147483644
        );

        showcase(testcases);
    }
}
