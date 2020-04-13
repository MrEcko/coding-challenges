package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class MiddleOfLinkedListTest extends Specification {
    @Shared
    private static MiddleOfLinkedList solution = new MiddleOfLinkedList()

    def "MiddleOfLinkedList"() {
        given:
        MiddleOfLinkedList.ListNode head = new MiddleOfLinkedList.ListNode(input[0])
        MiddleOfLinkedList.ListNode current = head
        head.next = current
        for (int i = 1; i < input.size(); i++) {
            current.next = new MiddleOfLinkedList.ListNode(input[i])
            current = current.next
        }

        when:
        def output = solution.middleNode(head)

        then:
        output
        output.val == expectedOut

        where:
        input              || expectedOut
        [1, 2, 3, 4, 5]    || 3
        [1, 2, 3, 4, 5, 6] || 4
    }
}

