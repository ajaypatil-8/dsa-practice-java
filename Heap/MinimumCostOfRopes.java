// Problem: Minimum Cost of Ropes
// Difficulty: Medium
// Topic: Heap
// GFG Link: https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public int minCost(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int x = pq.remove();
            int y = pq.remove();

            pq.add(x + y);
            cost += x + y;
        }

        return cost;
    }

    public static void main(String[] args) {

        MinimumCostOfRopes solution = new MinimumCostOfRopes();

        // Test 1
        int[] test1 = {4, 3, 2, 6};

        // Test 2
        int[] test2 = {4, 2, 7, 6, 9};

        // Test 3: edge case
        int[] test3 = {5};

        System.out.println("Test 1: " + solution.minCost(test1));
        System.out.println("Test 2: " + solution.minCost(test2));
        System.out.println("Test 3: " + solution.minCost(test3));
    }
}