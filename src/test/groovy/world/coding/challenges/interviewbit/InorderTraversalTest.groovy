package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class InorderTraversalTest extends Specification {
    @Shared
    private static InorderTraversal inorderTraversal = new InorderTraversal()

    def "InorderTraversal"() {
        given:
        InorderTraversal.TreeNode input = tree(1);
        input.left = tree(2)
        input.left.right = tree(3)

        input.right = tree(4)
        input.right.left = tree(5)
        input.right.left.right = tree(7)

        ArrayList<Integer> expectedOut = [2,3,1,5,7,4]

        expect:
        inorderTraversal.inorderTraversal(input) == expectedOut

    }

    private static InorderTraversal.TreeNode tree(int x){
        return new InorderTraversal.TreeNode(x)
    }
}

