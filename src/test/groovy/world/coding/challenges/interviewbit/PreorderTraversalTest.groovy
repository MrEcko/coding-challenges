package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class PreorderTraversalTest extends Specification {
    @Shared
    private static PreorderTraversal preorderTraversal = new PreorderTraversal()

    def "PreorderTraversal"() {
        given:
        PreorderTraversal.TreeNode input = tree(1);
        input.left = tree(2)
        input.left.right = tree(3)

        input.right = tree(4)
        input.right.left = tree(5)
        input.right.left.right = tree(7)

        ArrayList<Integer> expectedOut = [1,2,3,4,5,7]

        expect:
        preorderTraversal.preorderTraversal(input) == expectedOut
    }


    private static PreorderTraversal.TreeNode tree(int x){
        return new PreorderTraversal.TreeNode(x)
    }
}

