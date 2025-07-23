package solutions.Hashmap;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean res = true;

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) + 1);
            } else {
                map.put(c1, 1);
            }

            if (map.containsKey(c2)) {
                map.put(c2, map.get(c2) - 1);
            } else {
                map.put(c2, -1);
            }
        }

        for (int i : map.values()) {
            res = res && (i == 0);
        }

        return res;
    }

    private static void showcase(String[] strings) {
        for (int i = 0; i < strings.length - 1; i += 2) {
            String s = strings[i];
            String t = strings[i + 1];
            System.out.printf("is anagram?: %s, s: %s, t: %s %n", isAnagram(s, t), s, t);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "anagram", "nagaram",
                "rat", "car",
        };

        showcase(testcases);
    }
}
