package solutions.BinaryTreeGeneral;

import utility.TreeNode;

import java.util.List;

public class CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static void showcase(List<TreeNode> testcases) {
        for (TreeNode testcase : testcases) {
            System.out.printf("counted nodes: %d\n",
                    countNodes(testcase));
            testcase.show();
        }
    }

    public static void main(String[] args) {
        List<TreeNode> testcases = List.of(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                null)),
                new TreeNode(),
                new TreeNode(0)
        );

        showcase(testcases);
    }
}
