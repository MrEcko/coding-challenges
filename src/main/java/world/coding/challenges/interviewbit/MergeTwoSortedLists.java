package world.coding.challenges.interviewbit;

import java.util.Objects;

/**
 * https://www.interviewbit.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A==null) return B;
        if (B==null) return A;
        ListNode start;
        if (A.val <= B.val){
            start = new ListNode(A.val);
            A = A.next;
        } else {
            start = new ListNode(B.val);
            B = B.next;
        }
        ListNode current = start;
        while (A != null || B != null){
            if (B ==null || (A!=null && A.val <= B.val)){
                current.next = new ListNode(A.val);
                A = A.next;
            } else {
                current.next = new ListNode(B.val);
                B = B.next;
            }
            current = current.next;
        }
        return start;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append(val).append("->");
            ListNode next = this;
            while (next.next != null){
                next = next.next;
                output.append(next.val).append("->");
            }
            output.append("null");
            return output.toString();
        }
    }
}
