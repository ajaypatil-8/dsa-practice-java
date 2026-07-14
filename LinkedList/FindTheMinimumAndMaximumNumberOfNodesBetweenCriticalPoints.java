// Problem: Find the Minimum and Maximum Number of Nodes Between Critical Points
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

import java.util.Arrays;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

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

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int[] ans = new int[2];

        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;

        int idx = 2;
        int fidx = -1;
        int lidx = -1;
        int min = Integer.MAX_VALUE;
        int max = -1;

        while (c != null) {

            // current node is a critical point
            if ((b.val > a.val && b.val > c.val) ||
                (b.val < a.val && b.val < c.val)) {

                if (fidx == -1) {
                    fidx = idx;
                } else {
                    min = Math.min(min, idx - lidx);
                }

                lidx = idx;
            }

            a = a.next;
            b = b.next;
            c = c.next;
            idx++;
        }

        if (fidx == lidx) {
            return new int[]{-1, -1};
        }

        max = lidx - fidx;

        ans[0] = min;
        ans[1] = max;

        return ans;
    }

    public static void main(String[] args) {

        FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints solution =
                new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints();

        // Test 1: 3 -> 1 -> 5 -> 3 -> 7 -> 9
        ListNode test1 = new ListNode(3,
                new ListNode(1,
                new ListNode(5,
                new ListNode(3,
                new ListNode(7,
                new ListNode(9))))));

        // Test 2: 5 -> 3 -> 1 -> 2 -> 5 -> 1 -> 2
        ListNode test2 = new ListNode(5,
                new ListNode(3,
                new ListNode(1,
                new ListNode(2,
                new ListNode(5,
                new ListNode(1,
                new ListNode(2)))))));

        // Test 3: 1 -> 2 -> 3 (edge case)
        ListNode test3 = new ListNode(1,
                new ListNode(2,
                new ListNode(3)));

        System.out.println("Test 1: " +
                Arrays.toString(solution.nodesBetweenCriticalPoints(test1)));

        System.out.println("Test 2: " +
                Arrays.toString(solution.nodesBetweenCriticalPoints(test2)));

        System.out.println("Test 3: " +
                Arrays.toString(solution.nodesBetweenCriticalPoints(test3)));
    }
}