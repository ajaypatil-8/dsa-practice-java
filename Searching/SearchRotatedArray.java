// Problem: Search in Rotated Sorted Array
// Difficulty: Medium
// Topic: Searching
// Leetcode Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// GFG Link: https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1

public class SearchRotatedArray {

    static int search(int[] arr, int tar) {
        int l = 0, h = arr.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] == tar) return mid;

            // left half is sorted
            else if (arr[l] <= arr[mid]) {
                // target is in left half
                if (arr[l] <= tar && tar < arr[mid]) h = mid - 1;
                // target is in right half
                else l = mid + 1;
            }

            // right half is sorted
            else if (arr[mid] < arr[h]) {
                // target is in right half
                if (arr[mid] < tar && tar <= arr[h]) l = mid + 1;
                // target is in left half
                else h = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // target 3 is at index 4 after rotation
        int[] arr1 = {5, 6, 7, 8, 3, 4};
        System.out.println("Test 1: " + search(arr1, 3));

        // target not in array
        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test 2: " + search(arr2, 10));

        // single element matches
        int[] arr3 = {5};
        System.out.println("Test 3: " + search(arr3, 5));
    }
}