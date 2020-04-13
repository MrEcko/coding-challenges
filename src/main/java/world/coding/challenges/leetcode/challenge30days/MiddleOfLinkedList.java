package world.coding.challenges.leetcode.challenge30days;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode end = head;
        while (end != null && end.next != null) {
            end = end.next.next;
            mid = mid.next;
        }
        return mid;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
