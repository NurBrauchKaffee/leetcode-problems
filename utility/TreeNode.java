package utility;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public String tab = "";
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
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
