// Problem: Delete Node in a Linked List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

public class DeleteNodeInALinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public void deleteNode(ListNode node) {

        // copy next node's value
        node.val = node.next.val;

        // skip next node
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNodeInALinkedList solution = new DeleteNodeInALinkedList();

        // Test 1: 4 -> 5 -> 1 -> 9 (delete 5)
        ListNode test1 = new ListNode(4);
        test1.next = new ListNode(5);
        test1.next.next = new ListNode(1);
        test1.next.next.next = new ListNode(9);

        solution.deleteNode(test1.next);

        System.out.print("Test 1: ");
        printList(test1);

        // Test 2: 4 -> 5 -> 1 -> 9 (delete 1)
        ListNode test2 = new ListNode(4);
        test2.next = new ListNode(5);
        test2.next.next = new ListNode(1);
        test2.next.next.next = new ListNode(9);

        solution.deleteNode(test2.next.next);

        System.out.print("Test 2: ");
        printList(test2);

        // Test 3: 1 -> 2 (delete 1)
        ListNode test3 = new ListNode(1);
        test3.next = new ListNode(2);

        solution.deleteNode(test3);

        System.out.print("Test 3: ");
        printList(test3);
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