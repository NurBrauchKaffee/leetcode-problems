package TwoPointers;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;

        while (p2 < t.length() && p1 < s.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }

        return (p1 == s.length());
    }

    private static void showcase(String[] strings) {
        for (int i = 0; i < strings.length - 1; i += 2) {
            String s = strings[i];
            String t = strings[i + 1];
            System.out.printf("is subsequence?: %s, s: %s, t: %s %n", isSubsequence(s, t), s, t);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "bab", "ababab",
                "abc", "ahbgdc",
                "axc", "ahbgdc",
        };

        showcase(testcases);
    }
}
