package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class SwapListNodesInPairsTest extends Specification {
    @Shared
    private static SwapListNodesInPairs solution = new SwapListNodesInPairs()

    def "SwapListNodesInPairs"() {

        given: "1->2->3->4"
        SwapListNodesInPairs.ListNode one = node(1)
        def two = node(2)
        def three = node(3)
        three.next = node(4)
        two.next = three
        one.next = two

        when: "swapping"
        SwapListNodesInPairs.ListNode head = solution.swapPairs(one)

        then: "2->1->4->3"
        head.val == 2
        head.next.val == 1
        head.next.next.val == 4
        head.next.next.next.val == 3

    }

    private static SwapListNodesInPairs.ListNode node(int val) {
        new SwapListNodesInPairs.ListNode(val)
    }
}

