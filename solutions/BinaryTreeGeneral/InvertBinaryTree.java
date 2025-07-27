package solutions.BinaryTreeGeneral;

import utility.TreeNode;

import java.util.List;

public class InvertBinaryTree {
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

    private static void showcase(List<TreeNode> testcases) {
        for (TreeNode node : testcases) {
            System.out.println("inverted tree:");
            invertTree(node).show();
        }
    }

    public static void main(String[] args) {
        List<TreeNode> testcases = List.of(
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(1,
                        new TreeNode(2),
                        null),
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(7,
                                new TreeNode(6),
                                new TreeNode(9))),
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode()
        );

        showcase(testcases);
    }
}
