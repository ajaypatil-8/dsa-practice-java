// Problem: Odd Even Linked List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/odd-even-linked-list/

public class OddEvenLinkedList {

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

    public ListNode oddEvenList(ListNode head) {

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode t1 = dummy1;
        ListNode t2 = dummy2;
        ListNode t = head;

        int count = 1;

        while (t != null) {

            if (count % 2 == 0) {
                dummy2.next = t;
                dummy2 = dummy2.next;
            } else {
                dummy1.next = t;
                dummy1 = dummy1.next;
            }

            count++;
            t = t.next;
        }

        // end even list
        dummy2.next = null;

        // attach even list after odd list
        dummy1.next = t2.next;

        return t1.next;
    }

    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7
        ListNode test2 = new ListNode(2,
                new ListNode(1,
                new ListNode(3,
                new ListNode(5,
                new ListNode(6,
                new ListNode(4,
                new ListNode(7)))))));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.oddEvenList(test1));

        System.out.print("Test 2: ");
        printList(solution.oddEvenList(test2));

        System.out.print("Test 3: ");
        printList(solution.oddEvenList(test3));
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