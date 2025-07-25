package solutions.BinaryTreeGeneral;

import utility.Pair;

import java.util.List;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private static void showcase(List<Pair<TreeNode, TreeNode>> testcases) {
        for (Pair<TreeNode, TreeNode> pair : testcases) {
            System.out.printf("same tree?: %s%n", isSameTree(pair.first(), pair.second()));
        }
    }

    public static void main(String[] args) {
        List<Pair<TreeNode, TreeNode>> testcases = List.of(
                new Pair<>(
                        new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3)),
                        new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3))
                ),
                new Pair<>(
                        new TreeNode(1,
                                new TreeNode(2),
                                null),
                        new TreeNode(1,
                                null,
                                new TreeNode(2))
                )
        );

        showcase(testcases);
    }
}
