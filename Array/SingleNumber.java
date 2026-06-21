// Problem: Single Number
// Difficulty: Easy
// Topic: Bit Manipulation
// LeetCode Link: https://leetcode.com/problems/single-number/

public class SingleNumber {

    public int singleNumber(int[] arr) {
        int ans = 0;

        for (int elem : arr) {
            ans ^= elem;
        }

        return ans;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();

        int[] test1 = {2, 2, 1};
        int[] test2 = {4, 1, 2, 1, 2};
        int[] test3 = {1}; // edge case

        System.out.println("Test 1: " + solution.singleNumber(test1));
        System.out.println("Test 2: " + solution.singleNumber(test2));
        System.out.println("Test 3: " + solution.singleNumber(test3));
    }
}