package solutions.BinarySearch;

import utility.Pair;

import java.util.Arrays;
import java.util.List;

public class SearchInsertPosition {
    public static int helper(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;

        if (right - left == 1) {
            if (target <= nums[left]) {
                return left;
            } else {
                return left + 1;
            }
        }

        if (target <= nums[mid]) {
            return helper(nums, target, left, mid);
        } else {
            return helper(nums, target, mid, right);
        }
    }

    public static int searchInsert(int[] nums, int target) {
        return helper(nums, target, 0, nums.length);
    }

    private static void showcase(List<Pair<int[], Integer>> testcases) {
        for (Pair<int[], Integer> testcase : testcases) {
            System.out.printf("target index: %d, nums: %s, target: %d\n", searchInsert(testcase.first(), testcase.second()),
                    Arrays.toString(testcase.first()), testcase.second());
        }
    }

    public static void main(String[] args) {
        List<Pair<int[], Integer>> testcases = List.of(
                new Pair<>(new int[]{1, 3, 5, 6}, 5),
                new Pair<>(new int[]{1, 3, 5, 6}, 2),
                new Pair<>(new int[]{1, 3, 5, 6}, 7)
        );

        showcase(testcases);
    }
}
