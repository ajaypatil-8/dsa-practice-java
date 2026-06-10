// Problem: Find Peak Element
// Difficulty: Medium
// Topic: Searching, Binary Search
// LeetCode Link: https://leetcode.com/problems/find-peak-element/
// GFG Link: https://www.geeksforgeeks.org/problems/peak-element/1

public class FindPeakElement {

    public int findPeakElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // peak lies on right side
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                // peak is mid or on left side
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();

        int[] test1 = {1, 2, 3, 1};          // LeetCode example
        int[] test2 = {1, 2, 1, 3, 5, 6, 4}; // LeetCode example
        int[] test3 = {1};                   // edge case

        System.out.println("Test 1: " + solution.findPeakElement(test1));
        System.out.println("Test 2: " + solution.findPeakElement(test2));
        System.out.println("Test 3: " + solution.findPeakElement(test3));
    }
}