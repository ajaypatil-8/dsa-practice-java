// Problem: Last Stone Weight
// Difficulty: Easy
// Topic: Heap
// LeetCode Link: https://leetcode.com/problems/last-stone-weight/

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] arr) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        while (pq.size() > 1) {
            pq.add(Math.abs(pq.remove() - pq.remove()));
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        LastStoneWeight solution = new LastStoneWeight();

        // Test 1: LeetCode example
        int[] test1 = {2, 7, 4, 1, 8, 1};

        // Test 2: LeetCode example
        int[] test2 = {1};

        // Test 3: edge case
        int[] test3 = {5, 5};

        System.out.println("Test 1: " + solution.lastStoneWeight(test1));
        System.out.println("Test 2: " + solution.lastStoneWeight(test2));
        System.out.println("Test 3: " + solution.lastStoneWeight(test3));
    }
}