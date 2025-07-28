package solutions.DivideAndConquer;

import utility.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        switch (nums.length) {
            case 0 -> {
                return null;
            }
            case 1 -> {
                return new TreeNode(nums[0]);
            }
            case 2 -> {
                return new TreeNode(nums[1], new TreeNode(nums[0]), null);
            }
            case 3 -> {
                return new TreeNode(nums[1], new TreeNode(nums[0]), new TreeNode(nums[2]));
            }
            default -> {
                int offset = nums.length % 2 == 0 ? -1 : 0;
                int index = nums.length / 2 + offset;

                int[] leftPart = Arrays.copyOfRange(nums, 0, index);
                int[] rightPart = Arrays.copyOfRange(nums, index + 1, nums.length);

                return new TreeNode(nums[index], sortedArrayToBST(leftPart), sortedArrayToBST(rightPart));
            }
        }
    }

    private static void showcase(List<int[]> testcases) {
        for (int[] testcase : testcases) {
            System.out.println("converted tree:");
            Objects.requireNonNull(sortedArrayToBST(testcase)).show();
        }
    }

    public static void main(String[] args) {
        List<int[]> testcases = List.of(
                new int[]{-10, -3, 0, 5, 9},
                new int[]{1, 3}
        );

        showcase(testcases);
    }
}
