package solutions.Hashmap;

import java.util.HashMap;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> freqTable = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            if (freqTable.containsKey(c)) {
                freqTable.put(c, freqTable.get(c) + 1);
            } else {
                freqTable.put(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (freqTable.containsKey(c)) {
                freqTable.put(c, freqTable.get(c) - 1);
                if (freqTable.get(c) == 0) {
                    freqTable.remove(c);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    private static void showcase(String[] strings) {
        for (int i = 0; i < strings.length - 1; i += 2) {
            String ransomNote = strings[i];
            String magazine = strings[i + 1];
            System.out.printf("can construct?: %s, ransom note: %s, magazine: %s %n",
                    canConstruct(ransomNote, magazine), ransomNote, magazine);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "a", "b",
                "aa", "ab",
                "aa", "aab",
        };

        showcase(testcases);
    }
}
