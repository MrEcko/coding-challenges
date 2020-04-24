package world.coding.challenges.useful.tree;

/* Class containing left and right child of current
   node and key value*/
public class TreeNode
{
    public int value;
    public TreeNode left, right;
    public TreeNode(int item)
    {
        value = item;
        left = right = null;
    }
}
