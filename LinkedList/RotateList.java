// Problem: Rotate List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/rotate-list/

public class RotateList {

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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        int len = 0;

        // find length
        while (slow != null) {
            slow = slow.next;
            len++;
        }

        k %= len;

        if (k == 0) {
            return head;
        }

        // move fast k nodes ahead
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        slow = head;

        // find new tail
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // make it circular
        fast.next = head;

        // new head
        head = slow.next;
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {
        RotateList solution = new RotateList();

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: 0 -> 1 -> 2, k = 4
        ListNode test2 = new ListNode(0,
                new ListNode(1,
                new ListNode(2)));

        // Test 3: 1, k = 0 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.rotateRight(test1, 2));

        System.out.print("Test 2: ");
        printList(solution.rotateRight(test2, 4));

        System.out.print("Test 3: ");
        printList(solution.rotateRight(test3, 0));
    }

    private static void printList(ListNode head) {
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