package ArrayOrString;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int max = 0, maj = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > max) {
                max = freq;
                maj = key;
            }
        }
        return maj;
    }

    private static void showcase(int[][] nums) {
        for (int[] num : nums) {
            System.out.printf("majority element: %d, array: %s%n", majorityElement(num), Arrays.toString(num));
        }
    }

    public static void main(String[] args) {
        int[][] testcases = {
                {3,2,3},
                {2,2,1,1,1,2,2},
        };

        showcase(testcases);
    }
}
