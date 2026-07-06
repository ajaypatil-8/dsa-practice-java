// Problem: Remove Nth Node From End of List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndOfList {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // keep a gap of n nodes
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // move together
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove target node
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution =
                new RemoveNthNodeFromEndOfList();

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5, n = 2
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: 1 -> 2, n = 1
        ListNode test2 = new ListNode(1,
                new ListNode(2));

        // Test 3: 1, n = 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.removeNthFromEnd(test1, 2));

        System.out.print("Test 2: ");
        printList(solution.removeNthFromEnd(test2, 1));

        System.out.print("Test 3: ");
        printList(solution.removeNthFromEnd(test3, 1));
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