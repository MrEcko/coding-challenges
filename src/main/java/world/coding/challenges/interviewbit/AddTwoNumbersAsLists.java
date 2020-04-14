package world.coding.challenges.interviewbit;

import java.util.Objects;

/**
 * https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 */
public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if (A == null && B == null) return null;
        else if (A==null) return B;
        else if (B==null) return A;
        ListNode output = new ListNode(0);
        ListNode current = output;
        ListNode previous = current;
        boolean carryOver = false;
        int sum = 0;
        while ((A != null) || (B != null)){
            int a = A == null ? 0 : A.val;
            int b = B == null ? 0 : B.val;
            sum = a + b + (carryOver ? 1 : 0);
            if (sum > 9){
                carryOver = true;
                sum = sum % 10;
            } else{
                carryOver = false;
            }
            current.val = sum;
            current.next = new ListNode(0);
            previous = current;
            current = current.next;
            if (A != null){
                A = A.next;
            }
            if (B != null){
                B = B.next;
            }
        }
        if (carryOver) previous.next = new ListNode(1);
        else previous.next = null;

        return output;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

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

        ListNode(int x) {
            val = x;
            next = null;
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
