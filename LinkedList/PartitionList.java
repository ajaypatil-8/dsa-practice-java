// Problem: Partition List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/partition-list/

public class PartitionList {

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

    public ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode t1 = dummy1;
        ListNode t2 = dummy2;
        ListNode t = head;

        while (t != null) {

            if (t.val < x) {
                dummy1.next = t;
                dummy1 = dummy1.next;
            } else {
                dummy2.next = t;
                dummy2 = dummy2.next;
            }

            t = t.next;
        }

        dummy2.next = null;
        dummy1.next = t2.next;

        return t1.next;
    }

    public static void main(String[] args) {
        PartitionList solution = new PartitionList();

        // Test 1: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode test1 = new ListNode(1,
                new ListNode(4,
                new ListNode(3,
                new ListNode(2,
                new ListNode(5,
                new ListNode(2))))));

        // Test 2: 2 -> 1
        ListNode test2 = new ListNode(2,
                new ListNode(1));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.partition(test1, 3));

        System.out.print("Test 2: ");
        printList(solution.partition(test2, 2));

        System.out.print("Test 3: ");
        printList(solution.partition(test3, 2));
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