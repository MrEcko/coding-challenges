package world.coding.challenges.interviewbit;

import java.util.*;

public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        if (A != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(A);
            while (!stack.isEmpty()) {
                TreeNode currentNode = stack.pop();
                output.add(currentNode.val);
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            }
        }
        return output;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }
}
