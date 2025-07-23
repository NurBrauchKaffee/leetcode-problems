package solutions.TwoPointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int p1 = 0, p2 = n - 1;

        while (p2 - p1 > 0) {
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);

            if (!Character.isLetter(c1) && !Character.isDigit(c1)) {
                p1++;
                continue;
            }

            if (!Character.isLetter(c2) && !Character.isDigit(c2)) {
                p2--;
                continue;
            }

            if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                p1++; p2--;
            } else {
                return false;
            }
        }

        return true;
    }

    private static void showcase(String[] strings) {
        for (String s : strings) {
            System.out.printf("valid palindrome?: %s, string: %s%n", isPalindrome(s), s);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "0P",
                "A man, a plan, a canal: Panama",
                "race a car",
                " ",
        };

        showcase(testcases);
    }
}
