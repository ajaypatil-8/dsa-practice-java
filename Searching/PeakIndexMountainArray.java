// Problem: Peak Index in a Mountain Array
// Difficulty: Medium
// Topic: Searching
// GFG Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class PeakIndexMountainArray {

    static int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // still going up, move right
            if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                low = mid;
            }
            // going down, move left
            else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                high = mid;
            }
            // peak found, higher than both neighbors
            else if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // peak is at index 2
        int[] arr1 = {0, 1, 2, 1, 0};
        System.out.println("Test 1: " + peakIndexInMountainArray(arr1));

        // peak is at index 1
        int[] arr2 = {0, 10, 5, 2};
        System.out.println("Test 2: " + peakIndexInMountainArray(arr2));

        // peak is at index 3
        int[] arr3 = {1, 2, 3, 5, 3};
        System.out.println("Test 3: " + peakIndexInMountainArray(arr3));
    }
}