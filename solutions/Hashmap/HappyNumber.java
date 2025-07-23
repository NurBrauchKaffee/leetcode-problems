package solutions.Hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        int res = n;
        Set<Integer> used = new HashSet<>();

        while (res != 1) {
            String s = String.valueOf(res);
            res = 0;

            for (int i = 0; i < s.length(); i++) {
                res += (int) Math.pow((int) s.charAt(i) - 48, 2);
            }

            if (!used.add(res)) {
                return false;
            }
        }

        return true;
    }

    private static void showcase(int[] nums) {
        for (int num : nums) {
            System.out.printf("is happy?: %s, number: %d%n", isHappy(num), num);
        }
    }

    public static void main(String[] args) {
        int[] testcases = {
                19,
                2
        };

        showcase(testcases);
    }
}
