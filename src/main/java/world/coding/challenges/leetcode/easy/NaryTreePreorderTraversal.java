package world.coding.challenges.leetcode.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class NaryTreePreorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> output = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (stack.size() > 0) {
                Node currentNode = stack.pop();
                output.add(currentNode.val);
                if (currentNode.children != null && currentNode.children.size() > 0) {
                    for (int i = currentNode.children.size()-1; i >=0; i--) {
                        stack.push(currentNode.children.get(i));
                    }
                }
            }

        }

        return output;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
