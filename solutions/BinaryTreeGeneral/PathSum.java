package solutions.BinaryTreeGeneral;

import utility.Pair;

import java.util.HashSet;
import java.util.List;

public class PathSum {
    public boolean hasPathSumReference(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;

        }
        targetSum = targetSum - root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void leafSum(TreeNode node, int sum, HashSet<Integer> sums) {
        if (node == null) {
            return;
        }

        int newSum = sum + node.val;
        if (node.left == null && node.right == null) {
            sums.add(newSum);
        }

        if (node.left != null) {
            leafSum(node.left, newSum, sums);
        }

        if (node.right != null) {
            leafSum(node.right, newSum, sums);
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        HashSet<Integer> sums = new HashSet<>();
        leafSum(root, 0, sums);

        return sums.contains(targetSum);
    }

    private static void showcase(List<Pair<TreeNode, Integer>> testcases) {
        for (Pair<TreeNode, Integer> testcase : testcases) {
            System.out.printf("has path sum?: %s, target sum: %d\n",
                    hasPathSum(testcase.first(), testcase.second()),
                    testcase.second());
            testcase.first().show();
        }
    }

    public static void main(String[] args) {
        List<Pair<TreeNode, Integer>> testcases = List.of(
                new Pair<>(
                        new TreeNode(5,
                                new TreeNode(4,
                                        new TreeNode(11,
                                                new TreeNode(7),
                                                new TreeNode(2)),
                                        null),
                                new TreeNode(8,
                                        new TreeNode(13),
                                        new TreeNode(4,
                                                null,
                                                new TreeNode(1)
                                        )
                                )
                        ),
                        22
                ),
                new Pair<>(
                        new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3)),
                        5
                ),
                new Pair<>(new TreeNode(), 0)
        );

        showcase(testcases);
    }
}
