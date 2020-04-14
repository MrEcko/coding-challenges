package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class MergeTwoSortedListsTest extends Specification {
    @Shared
    private static MergeTwoSortedLists solution = new MergeTwoSortedLists()

    def "MergeTwoSortedLists"() {
        when:
        MergeTwoSortedLists.ListNode output = solution.mergeTwoLists(toLinkedList(a as int[]), toLinkedList(b as int[]))

        then:
        output == toLinkedList(expectedOut as int[])

        where:
        a          | b           || expectedOut
        [5, 8, 20] | [4, 11, 15] || [4, 5, 8, 11, 15, 20]
        [5, 8, 20] | [4, 11, 25] || [4, 5, 8, 11, 20, 25]
    }

    private static MergeTwoSortedLists.ListNode toLinkedList(int[] input) {
        MergeTwoSortedLists.ListNode head = node(input[0]);
        MergeTwoSortedLists.ListNode current = head;
        for (int i = 1; i < input.length; i++) {
            current.next = node(input[i])
            current = current.next
        }
        return head;
    }

    private static MergeTwoSortedLists.ListNode node(int val) {
        new MergeTwoSortedLists.ListNode(val)
    }
}

