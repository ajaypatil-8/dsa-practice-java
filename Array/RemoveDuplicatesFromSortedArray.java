// Problem: Remove Duplicates from Sorted Array
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] arr) {
        int wr = 1;

        for (int i = 1; i < arr.length; i++) {

            // found a new value
            if (arr[i] != arr[i - 1]) {
                arr[wr] = arr[i];
                wr++;
            }
        }

        return wr;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution =
                new RemoveDuplicatesFromSortedArray();

        int[] test1 = {1, 1, 2};
        int[] test2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] test3 = {1}; // edge case

        int k1 = solution.removeDuplicates(test1);
        int k2 = solution.removeDuplicates(test2);
        int k3 = solution.removeDuplicates(test3);

        System.out.println("Test 1: " +
                Arrays.toString(Arrays.copyOf(test1, k1)));

        System.out.println("Test 2: " +
                Arrays.toString(Arrays.copyOf(test2, k2)));

        System.out.println("Test 3: " +
                Arrays.toString(Arrays.copyOf(test3, k3)));
    }
}