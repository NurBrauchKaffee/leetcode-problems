package solutions.BinaryTreeGeneral;

import java.util.*;

public class MaximumDepthOfBinaryTree {
    public int maxDepthReference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthReference(root.left), maxDepthReference(root.right));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        List<Integer> depths = new ArrayList<>();

        DFS(root, depth, depths);
        depths.sort(Integer::compareTo);

        return depths.getLast();
    }

    public static void DFS(TreeNode v, int depth, List<Integer> depths) {
        depths.add(depth);

        if (v.left != null) {
            DFS(v.left, depth + 1, depths);
        }

        if (v.right != null) {
            DFS(v.right, depth + 1, depths);
        }
    }

    private static void showcase(List<TreeNode> testcases) {
        for (TreeNode node : testcases) {
            System.out.printf("depth: %d%n", maxDepth(node));
        }
    }

    public static void main(String[] args) {
        List<TreeNode> testcases = List.of(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4)),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)))
        );

        showcase(testcases);
    }
}
