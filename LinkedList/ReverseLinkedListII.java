// Problem: Reverse Linked List II
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/reverse-linked-list-ii/

public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            // reverse current node
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int l, int r) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = dummy;

        // reach left boundary
        for (int i = 1; i < l; i++) {
            left = left.next;
        }

        // reach right boundary
        for (int j = 1; j <= r; j++) {
            right = right.next;
        }

        ListNode head2 = left.next;
        ListNode tail1 = left;

        left.next = null;

        ListNode head3 = right.next;
        right.next = null;

        ListNode tail2 = head2;

        // reverse selected part
        head2 = reverseList(head2);

        // join all three parts
        tail1.next = head2;
        tail2.next = head3;

        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII solution = new ReverseLinkedListII();

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5, reverse 2 to 4
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: 5, reverse 1 to 1
        ListNode test2 = new ListNode(5);

        // Test 3: 3 -> 5, reverse 1 to 2 (edge case)
        ListNode test3 = new ListNode(3,
                new ListNode(5));

        System.out.print("Test 1: ");
        printList(solution.reverseBetween(test1, 2, 4));

        System.out.print("Test 2: ");
        printList(solution.reverseBetween(test2, 1, 1));

        System.out.print("Test 3: ");
        printList(solution.reverseBetween(test3, 1, 2));
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }

        System.out.println();
    }
}