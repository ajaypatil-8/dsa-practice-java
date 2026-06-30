// Problem: Missing Number
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/missing-number/

public class MissingNum {

    public int missingNumber(int[] nums) {

        int n = nums.length;

        // sum from 0 to n
        int nSum = n * (n + 1) / 2;

        int sum = 0;

        // actual array sum
        for (int num : nums) {
            sum += num;
        }

        return nSum - sum;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();

        int[] test1 = {3, 0, 1};
        int[] test2 = {0, 1};
        int[] test3 = {0}; // edge case

        System.out.println("Test 1: " + solution.missingNum(test1));
        System.out.println("Test 2: " + solution.missingNum(test2));
        System.out.println("Test 3: " + solution.missingNum(test3));
    }
}