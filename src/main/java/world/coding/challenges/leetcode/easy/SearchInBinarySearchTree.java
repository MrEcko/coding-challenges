package world.coding.challenges.leetcode.easy;

public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode output = null;
        if (root != null) {
            if (root.val == val) return root;
            output = findValueNonRecursive(root, val);
            //output = findValue(root,val);
        }
        return output;
    }

    TreeNode findValueNonRecursive(TreeNode root, int val) {
        TreeNode candidate = root;
        while (candidate != null && candidate.val != val) {
            if (val < candidate.val) {
                candidate = candidate.left;
            } else {
                candidate = candidate.right;
            }
        }
        return candidate;
    }

    TreeNode findValue(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return findValue(root.left, val);
        } else {
            return findValue(root.right, val);
        }
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
