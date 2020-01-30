package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

class NaryTreePostorderTraversalTest extends Specification {
    @Shared
    private static NaryTreePostorderTraversal solution = new NaryTreePostorderTraversal()

    def "NaryTreePostorderTraversal"() {
        given:
        NaryTreePostorderTraversal.Node input = node(1)
        def subtree = node(3)
        subtree.children = [node(5),node(6)]
        input.children = [subtree, node(2), node(4)]

        expect:
        solution.postorder(input) == [5,6,3,2,4,1]

    }

    private NaryTreePostorderTraversal.Node node(val) {
        new NaryTreePostorderTraversal.Node(val)
    }
}

