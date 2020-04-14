package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class RotateListTest extends Specification {
    @Shared
    private static RotateList solution = new RotateList()

    def "RotateList"() {
        given:
        RotateList.ListNode theInput = toLinkedList(input as int[])

        when:
        RotateList.ListNode output = solution.rotateRight(theInput, rotations)

        then:
        output == toLinkedList(expectedOut as int[])

        where:
        input           | rotations || expectedOut
        [1]             | 0         || [1]
        [1]             | 1         || [1]
        [1]             | 100       || [1]
        [1, 2, 3, 4, 5] | 0         || [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5] | 2         || [4, 5, 1, 2, 3]
        [1, 2, 3, 4, 5] | 3         || [3, 4, 5, 1, 2]
        [1, 2, 3, 4, 5] | 7         || [4, 5, 1, 2, 3]
    }

    private static RotateList.ListNode toLinkedList(int[] input) {
        RotateList.ListNode head = node(input[0]);
        RotateList.ListNode current = head;
        for (int i = 1; i < input.length; i++) {
            current.next = node(input[i])
            current = current.next
        }
        return head;
    }

    private static RotateList.ListNode node(int val) {
        new RotateList.ListNode(val)
    }
}

