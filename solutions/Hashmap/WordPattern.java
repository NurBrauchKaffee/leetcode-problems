package solutions.Hashmap;

import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c)) {
                if (!word.equals(map.get(c))) {
                    return false;
                }
            } else if (map.containsValue(word)) {
                return false;
            } else {
                map.put(c, word);
            }
        }

        return true;
    }

    private static void showcase(String[] strings) {
        for (int i = 0; i < strings.length - 1; i += 2) {
            String pattern = strings[i];
            String t = strings[i + 1];
            System.out.printf("follows pattern?: %s, pattern: %s, string: %s %n", wordPattern(pattern, t), pattern, t);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "abba", "dog cat cat dog",
                "abba", "dog cat cat fish",
                "aaaa", "dog cat cat dog",
        };

        showcase(testcases);
    }
}
