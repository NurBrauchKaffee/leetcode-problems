package solutions.Hashmap;

import utility.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ContainsDuplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();

        if (k + 1 > nums.length) {
            k = nums.length-1;
        }

        for (int i = 0; i <= k; i++) {
            if (!seen.add(nums[i])) {
                return true;
            }
        }

        for (int i = k + 1; i < nums.length; i++) {
            seen.remove(nums[i - k - 1]);
            if (!seen.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    private static void showcase(List<Pair<int[], Integer>> list) {
        for (Pair<int[], Integer> pair : list) {
            int[] nums = pair.first();
            int k = pair.second();
            System.out.printf("contains duplicate nearby?: %s, nums: %s, k: %d%n", containsNearbyDuplicate(nums, k), Arrays.toString(nums), k);
        }
    }

    public static void main(String[] args) {
        List<Pair<int[], Integer>> testcases = List.of(
                new Pair<>(new int[]{1, 2, 3, 1}, 3),
                new Pair<>(new int[]{1, 0, 1, 1}, 1),
                new Pair<>(new int[]{1, 2, 3, 1, 2, 3}, 2),
                new Pair<>(new int[]{1}, 1),
                new Pair<>(new int[]{99, 99}, 2),
                new Pair<>(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15)
        );

        showcase(testcases);
    }
}
