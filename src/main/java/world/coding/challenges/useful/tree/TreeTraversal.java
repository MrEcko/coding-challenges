package world.coding.challenges.useful.tree;

public class TreeTraversal {

    /**
     * Level order traversal (breadth first) of a tree is breadth first traversal for the tree.
     */
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal (breadth first) of binary tree is ");
        tree.printLevelOrderRecursive();
        tree.printLevelOrderIterative();


//        https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

        System.out.println("DepthFirstTraversals of binary tree is ");
        System.out.println("Pre order traversal of binary tree is ");
        tree.printPreorder();
        //Pre order traversal is used to create a copy of the tree.
        //Pre order traversal is also used to get prefix expression on of an expression tree.
        // Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.

        System.out.println("Inorder traversal of binary tree gives nodes in non-decreasing order:");
        tree.printInorder();
        //To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal s reversed can be used.

        System.out.println("\nPost order traversal of binary tree is ");
        tree.printPostorder();
        //Post order traversal is used to delete the tree. Please see the question for deletion of tree for details.
        //Post order traversal is also useful to get the postfix expression of an expression tree.
    }
}
