package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class AddTwoNumbersAsListsTest extends Specification {
    @Shared
    private static AddTwoNumbersAsLists solution = new AddTwoNumbersAsLists()

    def "AddTwoNumbersAsLists"() {
        given:
        AddTwoNumbersAsLists.ListNode theInput = toLinkedList(a as int[])

        when:
        AddTwoNumbersAsLists.ListNode output = solution.addTwoNumbers(toLinkedList(a as int[]), toLinkedList(b as int[]))

        then:
        output == toLinkedList(expectedOut as int[])

        where:
        a         | b         || expectedOut
        [1]       | [9, 9, 1] || [0, 0, 2]
        [1]       | [9, 9, 9] || [0, 0, 0, 1]
        [9, 9, 9] | [9, 9, 9] || [8, 9, 9, 1]
    }

    private static AddTwoNumbersAsLists.ListNode toLinkedList(int[] input) {
        AddTwoNumbersAsLists.ListNode head = node(input[0]);
        AddTwoNumbersAsLists.ListNode current = head;
        for (int i = 1; i < input.length; i++) {
            current.next = node(input[i])
            current = current.next
        }
        return head;
    }

    private static AddTwoNumbersAsLists.ListNode node(int val) {
        new AddTwoNumbersAsLists.ListNode(val)
    }
}

