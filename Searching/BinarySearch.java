// Problem: Binary Search
// Difficulty: Easy
// Topic: Searching
// GFG Link: https://leetcode.com/problems/binary-search/

public class BinarySearch {

    static int search(int[] arr, int tar) {
        int low = 0, high = arr.length - 1;

        // single element check
        if (arr.length == 1 && arr[0] == tar) return 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            // target is in left half
            if (arr[mid] > tar) high = mid - 1;
            // target is in right half
            else if (arr[mid] < tar) low = mid + 1;
            // found it
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        // target 4 is at index 3
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Test 1: " + search(arr1, 4));

        // target not in array
        int[] arr2 = {1, 3, 5, 7, 9};
        System.out.println("Test 2: " + search(arr2, 6));

        // single element matches
        int[] arr3 = {9};
        System.out.println("Test 3: " + search(arr3, 9));
    }
}