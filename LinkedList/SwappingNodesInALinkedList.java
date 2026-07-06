// Problem: Swapping Nodes in a Linked List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

public class SwappingNodesInALinkedList {

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

    public ListNode swapNodes(ListNode head, int k) {

        ListNode front = head;

        // reach kth node from start
        for (int i = 1; i < k; i++) {
            front = front.next;
        }

        ListNode temp = front;
        ListNode back = head;

        // reach kth node from end
        while (temp.next != null) {
            temp = temp.next;
            back = back.next;
        }

        // swap values
        int t = front.val;
        front.val = back.val;
        back.val = t;

        return head;
    }

    public static void main(String[] args) {
        SwappingNodesInALinkedList solution = new SwappingNodesInALinkedList();

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: 7 -> 9 -> 6 -> 6 -> 7 -> 8 -> 3 -> 0 -> 9 -> 5, k = 5
        ListNode test2 = new ListNode(7,
                new ListNode(9,
                new ListNode(6,
                new ListNode(6,
                new ListNode(7,
                new ListNode(8,
                new ListNode(3,
                new ListNode(0,
                new ListNode(9,
                new ListNode(5))))))))));

        // Test 3: 1, k = 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.print("Test 1: ");
        printList(solution.swapNodes(test1, 2));

        System.out.print("Test 2: ");
        printList(solution.swapNodes(test2, 5));

        System.out.print("Test 3: ");
        printList(solution.swapNodes(test3, 1));
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