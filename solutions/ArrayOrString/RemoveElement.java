package solutions.ArrayOrString;

import java.util.Arrays;

public class RemoveElement {
    public int removeElementRef(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;

    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int p1 = 0, p2 = n - 1;

        while (p2 - p1 > 0) {
            if (nums[p2] == val) {
                nums[p2--] = -1;
            }
            if (nums[p1] == val) {
                nums[p1] = nums[p2];
                nums[p2--] = -1;
            }
            p1++;
        }

        System.out.println("p1: " + p1 + ", p2: " + p2);
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,2,3};
        int val1 = 3;
        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;
        int[] nums3 = {3};
        int val3 = 2;
        int[] nums4 = {2,2,2};
        int val4 = 2;
        int[] nums5 = {1};
        int val5 = 1;

        System.out.println(removeElement(nums1, val1) + ", " + Arrays.toString(nums1));
        System.out.println(removeElement(nums2, val2) + ", " + Arrays.toString(nums2));
        System.out.println(removeElement(nums3, val3) + ", " + Arrays.toString(nums3));
        System.out.println(removeElement(nums4, val4) + ", " + Arrays.toString(nums4));
        System.out.println(removeElement(nums5, val5) + ", " + Arrays.toString(nums5));
    }
}
