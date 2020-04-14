package world.coding.challenges.interviewbit

import spock.lang.Shared
import spock.lang.Specification

class ReorderListTest extends Specification {
    @Shared
    private static ReorderList solution = new ReorderList()

    def "ReorderList"() {
        given:
        ReorderList.ListNode theInput = toLinkedList(input as int[])

        when:
        ReorderList.ListNode output = solution.reorderList(theInput)

        then:
        output == toLinkedList(expectedOut as int[])
        output == solution.reorderListRecursive(theInput)

        where:
        input              || expectedOut
        [1]                || [1]
        [1, 2]             || [1, 2]
        [1, 2, 3]          || [1, 3, 2]
        [1, 2, 3, 4]       || [1, 4, 2, 3]
        [1, 2, 3, 4, 5, 6] || [1, 6, 2, 5, 3, 4]
    }

    private static ReorderList.ListNode toLinkedList(int[] input) {
        ReorderList.ListNode head = node(input[0]);
        ReorderList.ListNode current = head;
        for (int i = 1; i < input.length; i++) {
            current.next = node(input[i])
            current = current.next
        }
        return head;
    }

    private static ReorderList.ListNode node(int val) {
        new ReorderList.ListNode(val)
    }
}

