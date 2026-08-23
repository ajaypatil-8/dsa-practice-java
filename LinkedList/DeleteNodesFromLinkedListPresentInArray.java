// Problem: Delete Nodes From Linked List Present in Array
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/

import java.util.HashSet;

public class DeleteNodesFromLinkedListPresentInArray {

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

    public ListNode modifiedList(int[] arr, ListNode head) {

        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode ans = dummy;
        ListNode temp = head;

        while (temp != null) {

            if (set.contains(temp.val)) {
                dummy.next = temp.next;
            } else {
                dummy = dummy.next;
            }

            temp = temp.next;
        }

        return ans.next;
    }

    public static void main(String[] args) {

        DeleteNodesFromLinkedListPresentInArray solution =
                new DeleteNodesFromLinkedListPresentInArray();

        // Test 1: arr = [1,2,3], list = 1 -> 2 -> 3 -> 4 -> 5
        int[] arr1 = {1, 2, 3};

        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: arr = [1], list = 1 -> 2 -> 1 -> 3
        int[] arr2 = {1};

        ListNode test2 = new ListNode(1,
                new ListNode(2,
                new ListNode(1,
                new ListNode(3))));

        // Test 3: empty list
        int[] arr3 = {1, 2};

        ListNode test3 = null;

        System.out.print("Test 1: ");
        printList(solution.modifiedList(arr1, test1));

        System.out.print("Test 2: ");
        printList(solution.modifiedList(arr2, test2));

        System.out.print("Test 3: ");
        printList(solution.modifiedList(arr3, test3));
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