package world.coding.challenges.useful.tree;

/* Class containing left and right child of current
   node and key value*/
class Node
{
    int value;
    Node left, right;
    public Node(int item)
    {
        value = item;
        left = right = null;
    }
}
