// Problem: Max Consecutive Ones
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/max-consecutive-ones/
// GFG Link:

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] arr) {
        int count = 0;
        int maxCount = 0;

        for (int elem : arr) {
            if (elem == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();

        int[] test1 = {1, 1, 0, 1, 1, 1};
        int[] test2 = {1, 0, 1, 1, 0, 1};
        int[] test3 = {0, 0, 0, 0}; // edge case

        System.out.println("Test 1: " + solution.findMaxConsecutiveOnes(test1));
        System.out.println("Test 2: " + solution.findMaxConsecutiveOnes(test2));
        System.out.println("Test 3: " + solution.findMaxConsecutiveOnes(test3));
    }
}