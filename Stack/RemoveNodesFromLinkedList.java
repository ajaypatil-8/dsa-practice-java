// Problem: Remove Nodes From Linked List
// Difficulty: Medium
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/remove-nodes-from-linked-list/

import java.util.Stack;

public class RemoveNodesFromLinkedList {

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

    public ListNode removeNodes(ListNode head) {

        Stack<ListNode> st = new Stack<>();

        while (head != null) {

            // remove smaller nodes
            if (!st.isEmpty() && head.val > st.peek().val) {

                while (!st.isEmpty() && st.peek().val < head.val) {
                    st.pop();
                }

                st.push(head);
            } else {
                st.push(head);
            }

            head = head.next;
        }

        ListNode temp = null;

        // rebuild list
        while (!st.isEmpty()) {
            st.peek().next = temp;
            temp = st.pop();
        }

        return temp;
    }

    public static void main(String[] args) {
        RemoveNodesFromLinkedList solution = new RemoveNodesFromLinkedList();

        // Test 1: 5 -> 2 -> 13 -> 3 -> 8
        ListNode test1 = new ListNode(5,
                new ListNode(2,
                new ListNode(13,
                new ListNode(3,
                new ListNode(8)))));

        // Test 2: 1 -> 1 -> 1 -> 1
        ListNode test2 = new ListNode(1,
                new ListNode(1,
                new ListNode(1,
                new ListNode(1))));

        // Test 3: 7 (edge case)
        ListNode test3 = new ListNode(7);

        System.out.print("Test 1: ");
        printList(solution.removeNodes(test1));

        System.out.print("Test 2: ");
        printList(solution.removeNodes(test2));

        System.out.print("Test 3: ");
        printList(solution.removeNodes(test3));
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