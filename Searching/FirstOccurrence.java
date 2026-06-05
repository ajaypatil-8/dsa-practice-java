// Problem: First Occurrence in Sorted Array (Binary Search)
// Difficulty: Easy
// Topic: Searching
// GFG Link: https://www.geeksforgeeks.org/problems/binary-search-1587115620/1

public class FirstOccurrence {

    static int firstSearch(int[] arr, int k) {
        int l = 0, h = arr.length - 1;

        // check first element right away
        if (arr[0] == k) return 0;

        while (l <= h) {
            int m = l + (h - l) / 2;

            // found it and its the first occurrence
            if (arr[m] == k && arr[m] > arr[m - 1]) return m;
            // go left
            else if (arr[m] >= k) h = m - 1;
            // go right
            else l = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // first occurrence of 5 is at index 2
        int[] arr1 = {1, 3, 5, 5, 5, 7, 9};
        System.out.println("Test 1: " + firstSearch(arr1, 5));

        // element not in array
        int[] arr2 = {1, 2, 3, 4, 6};
        System.out.println("Test 2: " + firstSearch(arr2, 5));

        // first occurrence is at index 0
        int[] arr3 = {2, 2, 2, 3, 4};
        System.out.println("Test 3: " + firstSearch(arr3, 2));
    }
}