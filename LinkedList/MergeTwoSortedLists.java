// Problem: Merge Two Sorted Lists
// Difficulty: Easy
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoSortedLists {

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

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;

        while (head1 != null && head2 != null) {

            // take smaller node
            if (head1.val <= head2.val) {
                dummy.next = head1;
                dummy = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                dummy = head2;
                head2 = head2.next;
            }
        }

        // attach remaining nodes
        if (head1 == null) {
            dummy.next = head2;
        } else if (head2 == null) {
            dummy.next = head1;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // Test 1: 1 -> 2 -> 4 and 1 -> 3 -> 4
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                new ListNode(4)));

        ListNode list2 = new ListNode(1,
                new ListNode(3,
                new ListNode(4)));

        // Test 2: empty list and empty list
        ListNode list3 = null;
        ListNode list4 = null;

        // Test 3: empty list and 0 (edge case)
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);

        System.out.print("Test 1: ");
        printList(solution.mergeTwoLists(list1, list2));

        System.out.print("Test 2: ");
        printList(solution.mergeTwoLists(list3, list4));

        System.out.print("Test 3: ");
        printList(solution.mergeTwoLists(list5, list6));
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