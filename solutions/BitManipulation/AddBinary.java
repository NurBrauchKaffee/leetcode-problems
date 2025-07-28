package solutions.BitManipulation;

import utility.Pair;

import java.util.List;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int l1 = a.length(), l2 = b.length();
        int diff = l1 - l2;

        if (diff != 0) {
            if (diff > 0) {
                for (int i = 0; i < diff; i++) {
                    b = "0".concat(b);
                }
                l2 = l1;
            } else {
                for (int i = 0; i < -diff; i++) {
                    a = "0".concat(a);
                }
                l1 = l2;
            }
        }

        int residue = 0;

        StringBuilder res = new StringBuilder();

        while (l1 != 0 && l2 != 0) {
            int p1 = a.charAt(--l1) - 48;
            int p2 = b.charAt(--l2) - 48;
            int sum = p1 + p2 + residue;

            if (sum > 1) {
                residue = 1;
                sum -= 2;
            } else {
                residue = 0;
            }

            res.append(sum);
        }

        if (residue != 0) {
            res.append(residue);
        }

        return res.reverse().toString();
    }

    public static void showcase(List<Pair<String, String>> testcases) {
        for (Pair<String, String> testcase : testcases) {
            System.out.printf("sum: %s, a: %s, b: %s\n",
                    addBinary(testcase.first(), testcase.second()), testcase.first(), testcase.second());
        }
    }

    public static void main(String[] args) {
        List<Pair<String, String>> testcases = List.of(
                new Pair<>("11", "1"),
                new Pair<>("1010", "1011")
        );

        showcase(testcases);
    }
}
