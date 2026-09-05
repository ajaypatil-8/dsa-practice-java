// Problem: Concatenation of Array
// Difficulty: Easy
// Topic: Array
// LeetCode Link: https://leetcode.com/problems/concatenation-of-array/

import java.util.Arrays;

public class ConcatenationOfArray {

    public int[] getConcatenation(int[] arr) {

        int[] ans = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {

            ans[i] = arr[i];
            ans[i + arr.length] = arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        ConcatenationOfArray solution =
                new ConcatenationOfArray();

        // Test 1: LeetCode example
        int[] test1 = {1, 2, 1};

        // Test 2: LeetCode example
        int[] test2 = {1, 3, 2, 1};

        // Test 3: edge case
        int[] test3 = {5};

        System.out.println("Test 1: " +
                Arrays.toString(solution.getConcatenation(test1)));

        System.out.println("Test 2: " +
                Arrays.toString(solution.getConcatenation(test2)));

        System.out.println("Test 3: " +
                Arrays.toString(solution.getConcatenation(test3)));
    }
}