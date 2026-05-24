// Problem: Search an Element in an Array
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1

public class LinearSearch {

    static int search(int[] arr, int x) {
        // go through each element and check
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        // element not found
        return -1;
    }

    public static void main(String[] args) {
        // element exists in middle
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Test 1: " + search(arr1, 3)); // expected: 2

        // element not in array
        int[] arr2 = {5, 10, 15, 20};
        System.out.println("Test 2: " + search(arr2, 7)); // expected: -1

        // single element, matches
        int[] arr3 = {9};
        System.out.println("Test 3: " + search(arr3, 9)); // expected: 0
    }
}