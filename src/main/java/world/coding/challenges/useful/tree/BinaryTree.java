package world.coding.challenges.useful.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    // Root of Binary Tree
    TreeNode root;

    public BinaryTree() {
        root = null;
    }
    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(TreeNode node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.value + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(TreeNode node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the value of node */
        System.out.print(node.value + " ");

        /* now recur on right child */
        printInorder(node.right);
    }



    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(TreeNode node) {
        if (node == null)
            return;

        /* first print value of node */
        System.out.print(node.value + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        printPostorder(root);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder() {
        printPreorder(root);
    }


    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            /* use the larger one */
            if (leftHeight > rightHeight)
                return(leftHeight+1);
            else return(rightHeight+1);
        }
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
            ? containsNodeRecursive(current.left, value)
            : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }


    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }


// =====================================================================================================================================


    /*   */

    /**
     * Given a binary tree. Print its nodes in level order using array for implementing queue
     * (Breadth First = level order)
     *
     *  Iterative Queue based Java program to do level order traversal of Binary Tree
     *
     *  Queue is implemented using an array with maximum size of 500.
     *  We can implement queue as linked list also.
     *
     *  Time Complexity: O(n) where n is number of nodes in the binary tree
     */
    public Integer[] printLevelOrderIterative()
    {

        if (root == null) {
            return new Integer[0];
        }
        List<Integer> output = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty())
        {
            TreeNode tempNode = nodes.poll();
            output.add(tempNode.value);
            System.out.print(tempNode.value + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                nodes.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                nodes.add(tempNode.right);
            }
        }
        return output.toArray(new Integer[0]);
    }

// =====================================================================================================================================
    // * Recursive Java program for level order traversal of Binary Tree
    // * Time Complexity: O(n^2) in worst case.
    // * For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree.
    // * So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).

    /**
     * function to print level order traversal of tree
     * takes O(n) time where n is the number of nodes in the skewed tree.
     */
    void printLevelOrderRecursive()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }


    /**
     * Print nodes at the given level
     * time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2)
     */
    void printGivenLevel (TreeNode root , int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.value + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

//    ===============================================================================================


}
