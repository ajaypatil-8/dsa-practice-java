// Problem: Move Zeroes
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/move-zeroes/

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {

                // put non-zero at front
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();

        int[] test1 = {0, 1, 0, 3, 12};
        int[] test2 = {0};
        int[] test3 = {1, 2, 3, 4}; // edge case

        solution.moveZeroes(test1);
        solution.moveZeroes(test2);
        solution.moveZeroes(test3);

        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Test 3: " + Arrays.toString(test3));
    }
}