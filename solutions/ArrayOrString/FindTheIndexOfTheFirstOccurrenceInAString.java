package solutions.ArrayOrString;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStrRef(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m > n) return -1;

        int i = 0, j = 0;

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == m) return i - m;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }

    private static void showcase(String[] strings) {
        for (int i = 0; i < strings.length - 1; i += 2) {
            String haystack = strings[i];
            String needle = strings[i + 1];
            System.out.printf("occurrence: %s, haystack: %s, needle: %s %n", strStr(haystack, needle), haystack, needle);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "sadbutsad", "sad",
                "leetcode", "leeto",
                "helloworld", "wor",
                "testing", "testing",
                "heyheyhey", "hey",
                "heyheyhey", "jey",
                "ahey", "hey",
        };

        showcase(testcases);
    }
}
