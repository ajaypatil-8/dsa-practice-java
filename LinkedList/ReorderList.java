// Problem: Reorder List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/reorder-list/

public class ReorderList {

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

    public static ListNode reverseList(ListNode head) {

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

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split list
        ListNode head2 = slow.next;
        slow.next = null;

        // reverse second half
        head2 = reverseList(head2);

        int count = 1;
        ListNode temp = head;

        // merge alternately
        while (head2 != null) {

            if (count % 2 != 0) {
                head = head.next;
                temp.next = head2;
                temp = temp.next;
            } else {
                head2 = head2.next;
                temp.next = head;
                temp = temp.next;
            }

            count++;
        }
    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();

        // Test 1: 1 -> 2 -> 3 -> 4
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4))));

        // Test 2: 1 -> 2 -> 3 -> 4 -> 5
        ListNode test2 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        solution.reorderList(test1);
        solution.reorderList(test2);
        solution.reorderList(test3);

        System.out.print("Test 1: ");
        printList(test1);

        System.out.print("Test 2: ");
        printList(test2);

        System.out.print("Test 3: ");
        printList(test3);
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