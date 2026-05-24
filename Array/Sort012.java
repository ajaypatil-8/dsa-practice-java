// Problem: Sort an array of 0s, 1s and 2s
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

import java.util.Arrays;

public class Sort012 {

    static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        // dutch national flag algorithm
        while (mid <= high) {

            if (arr[mid] == 0) {
                // swap with low, move both pointers
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }

            else if (arr[mid] == 1) {
                // 1 is already in place
                mid++;
            }

            else {
                // swap with high, only move high
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {
        // basic mix of 0s 1s and 2s
        int[] arr1 = {0, 1, 2, 0, 1, 2};
        sort012(arr1);
        System.out.println("Test 1: " + Arrays.toString(arr1));

        // all same
        int[] arr2 = {2, 2, 2};
        sort012(arr2);
        System.out.println("Test 2: " + Arrays.toString(arr2));

        // single element
        int[] arr3 = {0};
        sort012(arr3);
        System.out.println("Test 3: " + Arrays.toString(arr3));
    }
}