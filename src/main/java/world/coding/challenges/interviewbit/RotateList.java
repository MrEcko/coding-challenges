package world.coding.challenges.interviewbit;

import java.util.Objects;

/**
 * https://www.interviewbit.com/problems/rotate-list/
 * Gotchas: B can be > n  =>   B % n   where n = length of A
 * Making it a circular linked list and cutting between n-B and n-B+1 solves it
 */
public class RotateList {
    public ListNode rotateRight(ListNode A, int B) {
        int n = 1;
        ListNode first = A;
        if (A == null) return null;
        if (A.next == null) return A;

        while (A.next != null) {
            n++;
            A = A.next;
        }
        A.next = first;
        ListNode last = first;
        int rotations = B % n;
        for (int i = 1; i < n - rotations; i++) {
            last = last.next;
        }
        first = last.next;
        last.next = null;
        return first;
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
    }
}
