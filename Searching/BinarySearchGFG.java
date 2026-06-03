// Problem: Binary Search
// Difficulty: Easy
// Topic: Searching
// GFG Link: https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1

public class BinarySearchGFG {

    static boolean binarySearch(int[] arr, int tar) {
        int low = 0, high = arr.length - 1;

        // single element check
        if (arr.length == 1 && arr[0] == tar) return true;

        while (low <= high) {
            int mid = (low + high) / 2;
            // target in left half
            if (arr[mid] > tar) high = mid - 1;
            // target in right half
            else if (arr[mid] < tar) low = mid + 1;
            // found it
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // target 4 exists
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Test 1: " + binarySearch(arr1, 4));

        // target not in array
        int[] arr2 = {1, 3, 5, 7, 9};
        System.out.println("Test 2: " + binarySearch(arr2, 6));

        // single element matches
        int[] arr3 = {9};
        System.out.println("Test 3: " + binarySearch(arr3, 9));
    }
}