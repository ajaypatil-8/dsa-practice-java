// Problem: Selection Sort
// Difficulty: Easy
// Topic: Sorting
// GFG Link: https://www.geeksforgeeks.org/problems/selection-sort/1

import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // find minimum in remaining unsorted part
            int min = Integer.MAX_VALUE, mindx = -1;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    mindx = j;
                }
            }
            // swap minimum with current position
            int temp = arr[i];
            arr[i] = min;
            arr[mindx] = temp;
        }
    }

    public static void main(String[] args) {
        // random unsorted array
        int[] arr1 = {64, 25, 12, 22, 11};
        selectionSort(arr1);
        System.out.println("Test 1: " + Arrays.toString(arr1));

        // already sorted
        int[] arr2 = {1, 2, 3, 4, 5};
        selectionSort(arr2);
        System.out.println("Test 2: " + Arrays.toString(arr2));

        // single element
        int[] arr3 = {7};
        selectionSort(arr3);
        System.out.println("Test 3: " + Arrays.toString(arr3));
    }
}