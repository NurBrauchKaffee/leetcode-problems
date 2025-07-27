package solutions.BinaryTreeGeneral;

import utility.TreeNode;

import java.util.List;

public class SymmetricTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.right != null || root.left != null) {
            if (root.right == null) {
                root.right = invertTree(root.left);
                root.left = null;
            } else if (root.left == null) {
                root.left = invertTree(root.right);
                root.right = null;
            } else {
                TreeNode temp = root.left;
                root.left = invertTree(root.right);
                root.right = invertTree(temp);
            }
        }

        return root;
    }

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

    public static boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, invertTree(root.right));
    }

    private static void showcase(List<TreeNode> testcases) {
        for (TreeNode node : testcases) {
            System.out.printf("is symmetric?: %s\n", isSymmetric(node));
            node.show();
        }
    }

    public static void main(String[] args) {
        List<TreeNode> testcases = List.of(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4)),
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(3))),
                new TreeNode(1,
                        new TreeNode(2,
                                null,
                                new TreeNode(3)),
                        new TreeNode(2,
                                null,
                                new TreeNode(3))),
                new TreeNode()
        );

        showcase(testcases);
    }
}
