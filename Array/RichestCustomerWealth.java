// Problem: Richest Customer Wealth
// Difficulty: Easy
// Topic: Array
// LeetCode Link: https://leetcode.com/problems/richest-customer-wealth/

public class RichestCustomerWealth {

    public int maximumWealth(int[][] arr) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }

            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {

        RichestCustomerWealth solution =
                new RichestCustomerWealth();

        // Test 1: LeetCode example
        int[][] test1 = {
                {1, 2, 3},
                {3, 2, 1}
        };

        // Test 2: LeetCode example
        int[][] test2 = {
                {1, 5},
                {7, 3},
                {3, 5}
        };

        // Test 3: edge case
        int[][] test3 = {
                {5}
        };

        System.out.println("Test 1: " + solution.maximumWealth(test1));
        System.out.println("Test 2: " + solution.maximumWealth(test2));
        System.out.println("Test 3: " + solution.maximumWealth(test3));
    }
}