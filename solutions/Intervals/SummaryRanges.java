package solutions.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int p1 = 0, p2 = 1;

        if (nums.length == 0) {
            return res;
        }

        while (p2 < nums.length) {
            if (nums[p2] - nums[p1] == p2 - p1) {
                p2++;
            } else {
                if (p2 - p1 > 1) {
                    res.add(String.format("%d->%d", nums[p1], nums[p2-1]));
                } else {
                    res.add(String.format("%d", nums[p1]));
                }
                p1 = p2;
            }
        }

        if (p2 - p1 == 1) {
            res.add(String.format("%d", nums[p1]));
        } else {
            res.add(String.format("%d->%d", nums[p1], nums[p2-1]));
        }

        return res;
    }

    private static void showcase(int[][] testcases) {
        for (int[] nums : testcases) {
            System.out.printf("ranges: %s, numbers: %s%n", summaryRanges(nums), Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[][] testcases = {
                {0, 1, 2, 4, 5, 7},
                {0, 2, 3, 4, 6, 8, 9},
        };

        showcase(testcases);
    }
}
