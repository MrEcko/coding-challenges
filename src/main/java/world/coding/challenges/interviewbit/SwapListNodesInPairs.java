package world.coding.challenges.interviewbit;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
 */
public class SwapListNodesInPairs {


    public ListNode swapPairs(ListNode A) {
        if (A.next == null) return A;

        // first swap
        ListNode head = A.next;
        A.next = head.next;
        head.next = A;

        Stack<ListNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            ListNode previous = stack.pop();
            if (previous.next != null) {
                ListNode a = previous.next;
                if (a.next != null) {
                    ListNode b = a.next;
                    a.next = b.next;
                    b.next = a;
                    previous.next = b;
                    if (a.next != null) {
                        stack.push(a);
                    }
                }
            }
        }
        return head;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
