// Problem: Wave Array
// Difficulty: Easy
// Topic: Arrays
// GFG Link: https://www.geeksforgeeks.org/problems/wave-array-1587115621/1

import java.util.Arrays;

public class SortInWave {

    static void sortInWave(int[] arr) {
        // swap every adjacent pair to make wave pattern
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args) {
        // wave: each even index > neighbors
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        sortInWave(arr1);
        System.out.println("Test 1: " + Arrays.toString(arr1));

        // odd length array
        int[] arr2 = {2, 4, 7, 8, 9};
        sortInWave(arr2);
        System.out.println("Test 2: " + Arrays.toString(arr2));

        // single element, nothing to swap
        int[] arr3 = {5};
        sortInWave(arr3);
        System.out.println("Test 3: " + Arrays.toString(arr3));
    }
}