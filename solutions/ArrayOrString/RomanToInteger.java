package solutions.ArrayOrString;

import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int res = 0;
        char[] string = s.toCharArray();
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        res += map.get(string[0]);

        for (int i = 1; i < s.length(); i++) {
            if (string[i-1] == 'I') {
                if (string[i] == 'V' || string[i] == 'X') {
                    res = res + map.get(string[i]) - 2 * map.get(string[i-1]);
                } else {
                    res += map.get(string[i]);
                }
            } else if (string[i-1] == 'X') {
                if (string[i] == 'L' || string[i] == 'C') {
                    res = res + map.get(string[i]) - 2 * map.get(string[i-1]);
                } else {
                    res += map.get(string[i]);
                }
            } else if (string[i-1] == 'C') {
                if (string[i] == 'D' || string[i] == 'M') {
                    res = res + map.get(string[i]) - 2 * map.get(string[i-1]);
                } else {
                    res += map.get(string[i]);
                }
            } else {
                res += map.get(string[i]);
            }
        }
        return res;
    }

    private static void showcase(String[] strings) {
        for (String s : strings) {
            System.out.printf("number: %d, Roman string: %s%n", romanToInt(s), s);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "III",
                "LVIII",
                "MCMXCIV",
                "CXXIII"
        };

        showcase(testcases);
    }
}
