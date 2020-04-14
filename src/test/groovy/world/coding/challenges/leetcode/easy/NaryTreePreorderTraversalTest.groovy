package world.coding.challenges.leetcode.easy

import spock.lang.Shared
import spock.lang.Specification

class NaryTreePreorderTraversalTest extends Specification {
    @Shared
    private static NaryTreePreorderTraversal solution = new NaryTreePreorderTraversal()

    def "NaryTreePreorderTraversal"() {
        given:
        NaryTreePreorderTraversal.Node input = node(1)
        def subtree = node(3)
        subtree.children = [node(5),node(6)]
        input.children = [subtree, node(2), node(4)]

        expect:
        solution.postorder(input) == [1,3,5,6,2,4]

    }

    private NaryTreePreorderTraversal.Node node(val) {
        new NaryTreePreorderTraversal.Node(val)
    }
}

