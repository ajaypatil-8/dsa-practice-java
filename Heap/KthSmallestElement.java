// Problem: Kth Smallest Element
// Difficulty: Easy
// Topic: Heap
// GFG Link: https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public int kthSmallest(int[] nums, int k) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

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

        KthSmallestElement solution =
                new KthSmallestElement();

        // Test 1
        int[] test1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;

        // Test 2
        int[] test2 = {7, 10, 4, 3, 20, 15};
        int k2 = 4;

        // Test 3: edge case
        int[] test3 = {5};
        int k3 = 1;

        System.out.println("Test 1: " +
                solution.kthSmallest(test1, k1));

        System.out.println("Test 2: " +
                solution.kthSmallest(test2, k2));

        System.out.println("Test 3: " +
                solution.kthSmallest(test3, k3));
    }
}