package ArrayOrString;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return ++index;
    }

    private static void showcase(int[][] nums) {
        for (int[] num : nums) {
            System.out.printf("%d, nums: %s%n", removeDuplicates(num), Arrays.toString(num));
        }
    }

    public static void main(String[] args) {
        int[][] testcases = {
                {1,1,2},
                {0,0,1,1,1,2,2,3,3,4},
                {1,1,1,1,1,2,3,4,5},
                {},
        };


        showcase(testcases);
    }
}
