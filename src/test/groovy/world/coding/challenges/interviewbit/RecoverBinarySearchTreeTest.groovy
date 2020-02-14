package world.coding.challenges.interviewbit

import spock.lang.IgnoreRest;
import spock.lang.Shared;
import spock.lang.Specification;

class RecoverBinarySearchTreeTest extends Specification {
    @Shared
    private static RecoverBinarySearchTree solution = new RecoverBinarySearchTree()

    def "RecoverBinarySearchTree"() {
        given:
        RecoverBinarySearchTree.TreeNode input = tree(1);
        input.left = tree(2)
        input.right = tree(3)

        ArrayList<Integer> expectedOut = [1,2]

        expect:
        solution.recoverTree(input) == expectedOut
    }

    def "RecoverBinarySearchTree not adjacent"() {
        given:
        RecoverBinarySearchTree.TreeNode input = tree(6);
        input.left = tree(10)
        input.left.left = tree(1)
        input.left.right = tree(3)
        input.right = tree(2)
        input.right.left = tree(7)
        input.right.right = tree(12)

        ArrayList<Integer> expectedOut = [2,10]

        expect:
        solution.recoverTree(input) == expectedOut
    }

    private static RecoverBinarySearchTree.TreeNode tree(int x){
        return new RecoverBinarySearchTree.TreeNode(x)
    }


}

