// Problem: Remove Duplicates from Sorted List
// Difficulty: Easy
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesFromSortedList {

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

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode temp = head;

        while (temp.next != null) {

            // remove duplicate node
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution =
                new RemoveDuplicatesFromSortedList();

        // Test 1: 1 -> 1 -> 2
        ListNode test1 = new ListNode(1,
                new ListNode(1,
                new ListNode(2)));

        // Test 2: 1 -> 1 -> 2 -> 3 -> 3
        ListNode test2 = new ListNode(1,
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(3)))));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.deleteDuplicates(test1));

        System.out.print("Test 2: ");
        printList(solution.deleteDuplicates(test2));

        System.out.print("Test 3: ");
        printList(solution.deleteDuplicates(test3));
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