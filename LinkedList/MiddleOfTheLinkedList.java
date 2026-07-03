// Problem: Middle of the Linked List
// Difficulty: Easy
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/middle-of-the-linked-list/

public class MiddleOfTheLinkedList {

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

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // slow moves 1 step, fast moves 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode test2 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5,
                new ListNode(6))))));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.middleNode(test1));

        System.out.print("Test 2: ");
        printList(solution.middleNode(test2));

        System.out.print("Test 3: ");
        printList(solution.middleNode(test3));
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