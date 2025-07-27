package solutions.BinarySearchTree;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {
    public static void LNR(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            LNR(node.left, list);
        }

        list.add(node.val);

        if (node.right != null) {
            LNR(node.right, list);
        }
    }

    public static int getMinimumDifference(TreeNode root) {
        int minDiff = 100000;

        List<Integer> list = new ArrayList<>();
        LNR(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i+1) - list.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    private static void showcase(List<TreeNode> testcases) {
        for (TreeNode testcase : testcases) {
            System.out.printf("min diff: %d\n",
                    getMinimumDifference(testcase));
//            testcase.show();
        }
    }

    public static void main(String[] args) {
        List<TreeNode> testcases = List.of(
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(6)),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(48,
                                new TreeNode(12),
                                new TreeNode(49))),
                new TreeNode(236,
                        new TreeNode(104,
                                new TreeNode(),
                                new TreeNode(227)),
                        new TreeNode(701,
                                new TreeNode(),
                                new TreeNode(911)))
        );

        showcase(testcases);
    }
}
