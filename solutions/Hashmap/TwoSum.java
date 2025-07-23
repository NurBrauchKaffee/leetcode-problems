package solutions.Hashmap;

import utility.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        HashMap<Integer, Integer> residues = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            residues.put(target - num, i);
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (residues.containsKey(num) && i != residues.get(num)) {
                res[0] = i;
                res[1] = residues.get(num);
            }
        }

        return res;
    }

    private static void showcase(List<Pair<int[], Integer>> list) {
        for (Pair<int[], Integer> pair : list) {
            int[] nums = pair.first();
            int target = pair.second();
            System.out.printf("indices: %s, nums: %s, target: %d%n", Arrays.toString(twoSum(nums, target)), Arrays.toString(nums), target);
        }
    }

    public static void main(String[] args) {
        List<Pair<int[], Integer>> testcases = List.of(
                new Pair<>(new int[]{2, 7, 11, 15}, 9),
                new Pair<>(new int[]{3, 2, 4}, 6),
                new Pair<>(new int[]{3, 3}, 6)
        );

        showcase(testcases);
    }
}
