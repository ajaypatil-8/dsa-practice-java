// Problem: Reverse Linked List
// Difficulty: Easy
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {

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

        while (curr != null) {

            // save next node
            ListNode next = curr.next;

            // reverse link
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: 1 -> 2
        ListNode test2 = new ListNode(1,
                new ListNode(2));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.reverseList(test1));

        System.out.print("Test 2: ");
        printList(solution.reverseList(test2));

        System.out.print("Test 3: ");
        printList(solution.reverseList(test3));
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