package solutions.Math;

import java.util.List;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int left = 10, right = 1;
        while (x / left >= 10) {
            left *= 10;
        }

        while (left != 1) {
            if ((x / left) % 10 != (x / right) % 10) {
                return false;
            }
            left /= 10;
            right *= 10;
        }

        return true;
    }

    public static void showcase(List<Integer> testcases) {
        for (int testcase : testcases) {
            System.out.printf("is palindrome?: %s, number: %d\n", isPalindrome(testcase), testcase);
        }
    }

    public static void main(String[] args) {
        List<Integer> testcases = List.of(
                100,
                1,
                121,
                -121,
                10,
                1234554321,
                123454321
        );
//            System.out.printf("left: %d, right: %d\n", left, right);

        showcase(testcases);
    }
}
