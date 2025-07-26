package solutions.BinaryTreeGeneral;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    String tab = "";
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void show() {
        if (right != null) {
            right.tab += String.format("%s\t", tab);
            right.show();
        }

        if (left != null) {
            left.tab += String.format("%s\t", tab);
            left.show();
        }

        System.out.printf("%s%d\n", tab, val);
    }

    public static TreeNode listToTree(int[] list) {
        return new TreeNode();
    }
}
