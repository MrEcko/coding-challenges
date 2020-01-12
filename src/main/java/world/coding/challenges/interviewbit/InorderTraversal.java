package world.coding.challenges.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    /**
     * How would your solution work if you were allowed to change the original tree ?
     * How would it work if you were not allowed to change the tree but use additional memory ( track the number of times a node has appeared in the tree ) ?
     * How would it work if you were not even allowed the extra memory ?
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();

        Stack<TreeNode> nodesTraversed = new Stack<>();
        TreeNode currentNode = root;
        while (true) {
            if (currentNode != null) {
                nodesTraversed.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (nodesTraversed.isEmpty()) {
                    break;
                }
                currentNode = nodesTraversed.pop();
                output.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return output;
    }

    public ArrayList<Integer> editorialOption(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        Stack<TreeNode> nodesTraversed = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || nodesTraversed.size() > 0){
            while (currentNode !=  null){
                nodesTraversed.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = nodesTraversed.pop();
            output.add(currentNode.val);
            currentNode = currentNode.right;
        }

        return output;
    }

}
