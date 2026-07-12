// Problem: Swap Nodes in Pairs
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodesInPairs {

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

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode a = head;
        ListNode b = a.next;
        ListNode c = dummy;

        while (a != null && b != null) {

            // swap current pair
            c.next = b;
            a.next = b.next;
            b.next = a;

            // move to next pair
            c = a;
            a = a.next;

            if (a != null) {
                b = a.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();

        // Test 1: 1 -> 2 -> 3 -> 4
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4))));

        // Test 2: 1 -> 2 -> 3
        ListNode test2 = new ListNode(1,
                new ListNode(2,
                new ListNode(3)));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.swapPairs(test1));

        System.out.print("Test 2: ");
        printList(solution.swapPairs(test2));

        System.out.print("Test 3: ");
        printList(solution.swapPairs(test3));
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