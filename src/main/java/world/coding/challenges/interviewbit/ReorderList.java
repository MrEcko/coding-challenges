package world.coding.challenges.interviewbit;

import java.util.Objects;

/**
 * https://www.interviewbit.com/problems/reorder-list/
 */
public class ReorderList {



    public ListNode reorderList(ListNode A) {


        if(A == null) return A;

        ListNode root = A;
        ListNode slow = root;
        ListNode fast = slow.next;
        while(fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middleNode = slow.next;
        slow.next = null;

        ListNode r = reverseList(middleNode);

        ListNode temp = root;

        while(temp!= null && r!= null) {
            ListNode next1 = temp.next;
            temp.next = r;
            ListNode rNext = r.next;
            r.next = next1;
            r = rNext;
            temp = next1;
        }

        return root;
    }


    public  ListNode reverseList(ListNode root) {
        ListNode prev = null;

        ListNode curr = root;

        ListNode next = null;

        while (curr != null) {
            // System.out.println(curr.val);
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    ListNode reorderListRecursive(ListNode A) {
        if (A == null || A.next == null)
            return A;
        ListNode slow = A;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        print("split input ("+A+") in : " +slow + " and " + fast);
        ListNode temp = slow.next;
        slow.next = null;
        print("new slow " + slow);
        print("temp " + temp);
        ListNode newHead = reverse(temp);
        print("newHead " + newHead);
        return merge(A, newHead);

    }

    /**
     * go to the tail and then coming back move items to the right so they come in reverse order
     * ex. 1 -> 2 -> 3 -> 4 -> null
     * =>    found tail 4, bubbling back
     * =>[3]:   1 -> 2 -> 3 ; 4 -> 3 -> null
     * =>[2]:  1 -> 2 ; 4 -> 3 -> 2 -> null   //connection from 2 to 3 cut
     * =>[1]:  4 -> 3 -> 2 -> 1 -> null    //connection from 1 to 2 cut; 1 is now the tail
     */
    ListNode reverse(ListNode node) {
        if (node == null || node.next == null)
            return node; //found the tail (or there's nothing to reverse)
        ListNode tail = reverse(node.next);
        node.next.next = node;
        node.next = null; // this is the new tail
        return tail;
    }
    ListNode merge(ListNode head, ListNode head1) {
        if (head == null)
            return head1;
        if (head1 == null)
            return head;

        ListNode temp = merge(head.next, head1.next);
        print("head : " +head);
        print("head1: " +head1);
        head1.next = temp;
        head.next = head1;
        print("ret : " +head);
        return head;
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

    static void print(Object input){
        System.out.println(input);
    }


}
