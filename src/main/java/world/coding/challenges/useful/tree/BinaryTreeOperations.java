package world.coding.challenges.useful.tree;

public class BinaryTreeOperations {

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        System.out.println("BT contains node 6? " + bt.containsNode(6));
        System.out.println("BT contains node 4? " + bt.containsNode(4));
        System.out.println("BT contains node 1? " + bt.containsNode(1));
        System.out.println("BT contains node 9? " + bt.containsNode(9));
        bt.delete(9);
        System.out.println("Deleted node 9");
        System.out.println("BT contains node 9? " + bt.containsNode(9));

    }

}
