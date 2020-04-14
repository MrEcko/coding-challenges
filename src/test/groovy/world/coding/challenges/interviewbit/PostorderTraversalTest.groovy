package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class PostorderTraversalTest extends Specification {
    @Shared
    private static PostorderTraversal postorderTraversal = new PostorderTraversal()

    def "PostorderTraversal"() {
        given:
        PostorderTraversal.TreeNode input = tree(1);
        input.left = tree(2)
        input.left.right = tree(3)

        input.right = tree(4)
        input.right.left = tree(5)
        input.right.left.right = tree(7)

        ArrayList<Integer> expectedOut = [3,2,7,5,4,1]

        expect:
        postorderTraversal.postorderTraversal(input ) == expectedOut
    }

    private static PostorderTraversal.TreeNode tree(int x){
        return new PostorderTraversal.TreeNode(x)
    }
}

