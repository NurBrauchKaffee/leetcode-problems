package solutions.BinaryTreeBFS;

import utility.TreeNode;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public static void BFS(Queue<TreeNode> queue, List<Double> avgs) {
        if (queue.isEmpty()) {
            return;
        }

        Queue<TreeNode> nextQueue = new ArrayDeque<>();
        double avg = 0;
        int counter = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            if (curr.left != null) {
                counter++;
                avg += curr.left.val;
                nextQueue.add(curr.left);
            }

            if (curr.right != null) {
                counter++;
                avg += curr.right.val;
                nextQueue.add(curr.right);
            }
        }

        if (counter != 0) {
            avgs.add(avg / counter);
        }

        BFS(nextQueue, avgs);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> res = new ArrayList<>();

        queue.add(root);
        res.add((double) root.val);

        BFS(queue, res);

        return res;
    }

    private static void showcase(List<TreeNode> testcases) {
        for (TreeNode testcase : testcases) {
            System.out.printf("average of levels: %s\n",
                    averageOfLevels(testcase));
//            testcase.show();
        }
    }

    public static void main(String[] args) {
        List<TreeNode> testcases = List.of(
                new TreeNode(3,
                        new TreeNode(9,
                                new TreeNode(1),
                                new TreeNode(1)),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7))),
                new TreeNode(3,
                        new TreeNode(9,
                                new TreeNode(15),
                                new TreeNode(7)),
                        new TreeNode(20))
        );

        showcase(testcases);
    }
}
