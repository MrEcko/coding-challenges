package world.coding.challenges.leetcode.challenge30days;

import world.coding.challenges.useful.tree.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    int i;

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    /**
     * left recursion will take the elements smaller than node.val
     * right recursion will take the remaining elements smaller than bound
     */
    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.value);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}
