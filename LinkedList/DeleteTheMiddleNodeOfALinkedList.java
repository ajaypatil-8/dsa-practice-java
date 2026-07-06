// Problem: Delete the Middle Node of a Linked List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class DeleteTheMiddleNodeOfALinkedList {

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

    public ListNode deleteMiddle(ListNode head) {

        ListNode temp = head;

        // empty or single node
        if (temp == null || temp.next == null) {
            return null;
        }

        int len = 0;

        // find length
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;

        // reach node before middle
        for (int i = 1; i < len / 2; i++) {
            temp = temp.next;
        }

        // remove middle node
        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        DeleteTheMiddleNodeOfALinkedList solution =
                new DeleteTheMiddleNodeOfALinkedList();

        // Test 1: 1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
        ListNode test1 = new ListNode(1,
                new ListNode(3,
                new ListNode(4,
                new ListNode(7,
                new ListNode(1,
                new ListNode(2,
                new ListNode(6)))))));

        // Test 2: 1 -> 2 -> 3 -> 4
        ListNode test2 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4))));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.deleteMiddle(test1));

        System.out.print("Test 2: ");
        printList(solution.deleteMiddle(test2));

        System.out.print("Test 3: ");
        printList(solution.deleteMiddle(test3));
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