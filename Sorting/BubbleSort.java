// Problem: Bubble Sort
// Difficulty: Easy
// Topic: Sorting
// GFG Link: https://www.geeksforgeeks.org/problems/bubble-sort/1

import java.util.Arrays;

public class BubbleSort {

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        // outer loop controls passes
        for (int j = 1; j < n; j++) {
            // inner loop bubbles largest to end each pass
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // random unsorted array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr1);
        System.out.println("Test 1: " + Arrays.toString(arr1));

        // already sorted
        int[] arr2 = {1, 2, 3, 4, 5};
        bubbleSort(arr2);
        System.out.println("Test 2: " + Arrays.toString(arr2));

        // single element
        int[] arr3 = {7};
        bubbleSort(arr3);
        System.out.println("Test 3: " + Arrays.toString(arr3));
    }
}