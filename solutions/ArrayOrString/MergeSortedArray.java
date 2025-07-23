package solutions.ArrayOrString;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        int m = 1, n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
