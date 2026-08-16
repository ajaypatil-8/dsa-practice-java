// Problem: Remove Duplicates from Sorted List II
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class RemoveDuplicatesFromSortedListII {

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
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        dummy.next = head;

        while (temp != null) {

            if (temp.next == null || temp.val != temp.next.val) {
                dummy.next = temp;
                dummy = dummy.next;
            } else {

                // skip all duplicates
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
            }

            temp = temp.next;
        }

        dummy.next = temp;

        return ans.next;
    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedListII solution =
                new RemoveDuplicatesFromSortedListII();

        // Test 1: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(3,
                new ListNode(4,
                new ListNode(4,
                new ListNode(5)))))));

        // Test 2: 1 -> 1 -> 1 -> 2 -> 3
        ListNode test2 = new ListNode(1,
                new ListNode(1,
                new ListNode(1,
                new ListNode(2,
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