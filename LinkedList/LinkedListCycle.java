// Problem: Linked List Cycle
// Difficulty: Easy
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/linked-list-cycle/

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode temp = head;
        ListNode temp2x = head;

        // slow moves 1 step, fast moves 2
        while (temp2x != null && temp2x.next != null) {

            temp = temp.next;
            temp2x = temp2x.next.next;

            // pointers meet if cycle exists
            if (temp == temp2x) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Test 1: 3 -> 2 -> 0 -> -4 (cycle to node 2)
        ListNode test1 = new ListNode(3);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(0);
        test1.next.next.next = new ListNode(-4);
        test1.next.next.next.next = test1.next;

        // Test 2: 1 -> 2 (cycle to node 1)
        ListNode test2 = new ListNode(1);
        test2.next = new ListNode(2);
        test2.next.next = test2;

        // Test 3: 1 (no cycle)
        ListNode test3 = new ListNode(1);

        System.out.println("Test 1: " + solution.hasCycle(test1));
        System.out.println("Test 2: " + solution.hasCycle(test2));
        System.out.println("Test 3: " + solution.hasCycle(test3));
    }
}