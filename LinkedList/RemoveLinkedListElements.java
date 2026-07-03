// Problem: Remove Linked List Elements
// Difficulty: Easy
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/remove-linked-list-elements/

public class RemoveLinkedListElements {

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

    public ListNode removeElements(ListNode head, int val) {

        // remove matching nodes from the front
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {

            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();

        // Test 1: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(6,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5,
                new ListNode(6)))))));

        // Test 2: 7 -> 7 -> 7 -> 7
        ListNode test2 = new ListNode(7,
                new ListNode(7,
                new ListNode(7,
                new ListNode(7))));

        // Test 3: empty list
        ListNode test3 = null;

        System.out.print("Test 1: ");
        printList(solution.removeElements(test1, 6));

        System.out.print("Test 2: ");
        printList(solution.removeElements(test2, 7));

        System.out.print("Test 3: ");
        printList(solution.removeElements(test3, 1));
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