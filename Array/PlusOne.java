// Problem: Plus One
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/plus-one/

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] arr) {

        for (int j = arr.length - 1; j >= 0; j--) {

            if (arr[j] < 9) {
                arr[j] += 1;
                return arr;
            } else {
                arr[j] = 0;
            }
        }

        int[] ans = new int[arr.length + 1];
        ans[0] = 1;

        return ans;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();

        int[] test1 = {1, 2, 3};
        int[] test2 = {4, 3, 2, 1};
        int[] test3 = {9, 9, 9}; // edge case

        System.out.println("Test 1: " +
                Arrays.toString(solution.plusOne(test1)));

        System.out.println("Test 2: " +
                Arrays.toString(solution.plusOne(test2)));

        System.out.println("Test 3: " +
                Arrays.toString(solution.plusOne(test3)));
    }
}