// Problem: Kth Largest Element in an Array
// Difficulty: Medium
// Topic: Heap
// LeetCode Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {

            if (pq.size() >= k) {
                pq.add(nums[i]);
                pq.remove();
            } else {
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        KthLargestElementInAnArray solution =
                new KthLargestElementInAnArray();

        // Test 1: LeetCode example
        int[] test1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;

        // Test 2: LeetCode example
        int[] test2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;

        // Test 3: edge case
        int[] test3 = {1};
        int k3 = 1;

        System.out.println("Test 1: " +
                solution.findKthLargest(test1, k1));

        System.out.println("Test 2: " +
                solution.findKthLargest(test2, k2));

        System.out.println("Test 3: " +
                solution.findKthLargest(test3, k3));
    }
}