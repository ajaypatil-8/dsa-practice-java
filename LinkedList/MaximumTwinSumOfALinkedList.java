// Problem: Maximum Twin Sum of a Linked List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

public class MaximumTwinSumOfALinkedList {

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

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            // reverse current link
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        int maxSum = 0;

        // find middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split list
        ListNode head2 = slow.next;
        slow.next = null;

        // reverse second half
        head2 = reverseList(head2);

        // find maximum twin sum
        while (head2 != null) {

            int sum = head.val + head2.val;

            if (sum > maxSum) {
                maxSum = sum;
            }

            head = head.next;
            head2 = head2.next;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumTwinSumOfALinkedList solution =
                new MaximumTwinSumOfALinkedList();

        // Test 1: 5 -> 4 -> 2 -> 1
        ListNode test1 = new ListNode(5,
                new ListNode(4,
                new ListNode(2,
                new ListNode(1))));

        // Test 2: 4 -> 2 -> 2 -> 3
        ListNode test2 = new ListNode(4,
                new ListNode(2,
                new ListNode(2,
                new ListNode(3))));

        // Test 3: 1 -> 100000 (edge case)
        ListNode test3 = new ListNode(1,
                new ListNode(100000));

        System.out.println("Test 1: " + solution.pairSum(test1));
        System.out.println("Test 2: " + solution.pairSum(test2));
        System.out.println("Test 3: " + solution.pairSum(test3));
    }
}