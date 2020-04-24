package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification
import world.coding.challenges.useful.tree.BinaryTree
import world.coding.challenges.useful.tree.TreeNode;

class ConstructBinarySearchTreeFromPreorderTraversalTest extends Specification {
    @Shared
    private static ConstructBinarySearchTreeFromPreorderTraversal solution = new ConstructBinarySearchTreeFromPreorderTraversal()

    def "ConstructBinarySearchTreeFromPreorderTraversal"() {
        when:
        TreeNode output = solution.bstFromPreorder(input as int[])
        then:
        new BinaryTree(output).printLevelOrderIterative() == expectedOut as Integer[]

        where:
        input              || expectedOut
        [8,5,1,7,10,12] || [8,5,10,1,7,null,12]
    }

}

