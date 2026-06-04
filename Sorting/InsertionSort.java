// Problem: Insertion Sort
// Difficulty: Easy
// Topic: Sorting
// GFG Link: https://www.geeksforgeeks.org/problems/insertion-sort/1

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            // keep swapping left until element is in right place
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        // random unsorted array
        int[] arr1 = {12, 11, 13, 5, 6};
        insertionSort(arr1);
        System.out.println("Test 1: " + Arrays.toString(arr1));

        // reverse sorted, worst case
        int[] arr2 = {5, 4, 3, 2, 1};
        insertionSort(arr2);
        System.out.println("Test 2: " + Arrays.toString(arr2));

        // single element
        int[] arr3 = {7};
        insertionSort(arr3);
        System.out.println("Test 3: " + Arrays.toString(arr3));
    }
} 
    
