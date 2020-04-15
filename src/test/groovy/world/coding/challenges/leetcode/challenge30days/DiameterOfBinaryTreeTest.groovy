package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class DiameterOfBinaryTreeTest extends Specification {
    @Shared
    private static DiameterOfBinaryTree solution = new DiameterOfBinaryTree()

    def "DiameterOfBinaryTree"() {
        given:
        DiameterOfBinaryTree.TreeNode root = node(1);
        root.left = node(2)
        root.right = node(3)
        root.left.left = node(4)
        root.left.right = node(5)

        expect:
        solution.diameterOfBinaryTree(root) == 3
    }

    private DiameterOfBinaryTree.TreeNode node(Integer val) {
        new DiameterOfBinaryTree.TreeNode(val)
    }
}

