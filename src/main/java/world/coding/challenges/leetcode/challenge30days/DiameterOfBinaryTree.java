package world.coding.challenges.leetcode.challenge30days;

public class DiameterOfBinaryTree {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        int l = 0, r = 0;
        if (node.left != null) {
            l += 1;
            l += dfs(node.left);
        }
        if (node.right != null) {
            r += 1;
            r += dfs(node.right);
        }

        diameter = Math.max(diameter, (l + r));
        return Math.max(l, r);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
