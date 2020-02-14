package world.coding.challenges.interviewbit;

import java.util.ArrayList;


/**
 * https://www.interviewbit.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {


    public TreeNode first;
    public TreeNode sec;
    public TreeNode prev;
    public void recover(TreeNode root) {
        if (root == null) return;
        // go to left side
        recover(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            sec = root;
        }
        prev = root;
        // go to right side
        recover(root.right);
    }

    public ArrayList<Integer> recoverTree(TreeNode A) {
        first = null;
        sec = null;
        prev = null;
        recover(A);
        ArrayList<Integer> output = new ArrayList<>();
        if (first != null){
            output.add(sec.val);
            output.add(first.val);
        }


        return output;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

}
