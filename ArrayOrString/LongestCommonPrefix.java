package ArrayOrString;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder lcp = new StringBuilder();
        int i = 0, n = 10000;
        boolean isTerminal = false;

        for (String str : strs) {
            if (str.length() < n) {
                n = str.length();
            }
        }

        while (i < n) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    isTerminal = true;
                    break;
                }
            }
            if (isTerminal) {
                break;
            }
            lcp.append(c);
            i++;
        }

        return lcp.toString();
    }

    private static void showcase(String[][] strings) {
        for (String[] s : strings) {
            System.out.printf("lcp: %s, strings: %s%n", longestCommonPrefix(s), Arrays.toString(s));
        }
    }

    public static void main(String[] args) {
        String[][] testcases = {
                {"c","acc","ccc"},
                {"flower","flow","flight"},
                {"dog","racecar","car"}
        };

        showcase(testcases);
    }
}
