package world.coding.challenges.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {

    /**
     * traverses the tree by deleting the nodes
     * an alternative without mutating the input is to store visited nodes in a map
     * @param A the tree
     * @return list of nodes traversed post order
     */
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
            ArrayList<Integer> output = new ArrayList<>();
            if (A != null) {
                Stack<TreeNode> stack = new Stack<>();

                stack.push(A);
                while(!stack.isEmpty()){
                    TreeNode currentNode = stack.peek();
                    if (currentNode.left == null && currentNode.right == null){
                        output.add(currentNode.val);
                        stack.pop();
                    }
                    if (currentNode.right != null)
                        stack.push(currentNode.right);
                    currentNode.right = null;
                    if (currentNode.left != null){
                        stack.push(currentNode.left);
                        currentNode.left = null;
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
