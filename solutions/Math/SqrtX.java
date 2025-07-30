package solutions.Math;

import java.util.ArrayList;
import java.util.List;

public class SqrtX {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int res = 1;

        for (int i = 1; i < x; i++) {
            if (i * i == x) {
                res = i;
                break;
            } else if (i * i > x || i * i < 0) {
                res = i - 1;
                break;
            }
        }

        return res;
    }

    public static void showcase(List<Integer> testcases) {
        for (int testcase : testcases) {
            System.out.printf("sqrt: %s, number: %d\n", mySqrt(testcase), testcase);
        }
    }

    public static void main(String[] args) {
        List<Integer> testcases = List.of(
                2147483647,
                4,
                8,
                9
        );

//        List<Integer> testcases = new ArrayList<>();
//        for (int i = 0; i < 25; i++) {
//            testcases.add(i);
//        }

        showcase(testcases);
    }
}
