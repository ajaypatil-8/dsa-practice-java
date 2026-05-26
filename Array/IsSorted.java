// Problem: Check if Array is Sorted
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1

public class IsSorted {

    static boolean isSorted(int[] arr) {
        // single element is always sorted
        if (arr.length == 1) {
            return true;
        }
        // if any element is greater than next, not sorted
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // sorted array
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Test 1: " + isSorted(arr1));

        // not sorted
        int[] arr2 = {1, 3, 2, 4, 5};
        System.out.println("Test 2: " + isSorted(arr2));

        // single element
        int[] arr3 = {7};
        System.out.println("Test 3: " + isSorted(arr3));
    }
}