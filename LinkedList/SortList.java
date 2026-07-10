// Problem: Sort List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/sort-list/

public class SortList {

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

    public ListNode sortList(ListNode head) {

        // empty or single node
        if (head == null || head.next == null) {
            return head;
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

        // sort both halves
        head = sortList(head);
        head2 = sortList(head2);

        // merge sorted lists
        return mergeTwoLists(head, head2);
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;

        while (head1 != null && head2 != null) {

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

        if (head1 == null) {
            dummy.next = head2;
        } else {
            dummy.next = head1;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        SortList solution = new SortList();

        // Test 1: 4 -> 2 -> 1 -> 3
        ListNode test1 = new ListNode(4,
                new ListNode(2,
                new ListNode(1,
                new ListNode(3))));

        // Test 2: -1 -> 5 -> 3 -> 4 -> 0
        ListNode test2 = new ListNode(-1,
                new ListNode(5,
                new ListNode(3,
                new ListNode(4,
                new ListNode(0)))));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.sortList(test1));

        System.out.print("Test 2: ");
        printList(solution.sortList(test2));

        System.out.print("Test 3: ");
        printList(solution.sortList(test3));
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