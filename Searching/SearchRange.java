// Problem: Find First and Last Position of Element in Sorted Array
// Difficulty: Medium
// Topic: Searching
// Leetcode Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// GFG Link:

import java.util.Arrays;

public class SearchRange {

    static int[] searchRange(int[] nums, int target) {
        int firstt = first(nums, target);
        int lastt = last(nums, target);
        return new int[]{firstt, lastt};
    }

    private static int first(int[] arr, int tar) {
        int l = 0, h = arr.length - 1;
        int ans = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] == tar) {
                // save and keep going left for first
                ans = m;
                h = m - 1;
            } else if (arr[m] < tar) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return ans;
    }

    private static int last(int[] arr, int tar) {
        int l = 0, h = arr.length - 1;
        int ans = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] == tar) {
                // save and keep going right for last
                ans = m;
                l = m + 1;
            } else if (arr[m] < tar) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // first at 3, last at 4
        int[] arr1 = {5, 7, 7, 8, 8, 10};
        System.out.println("Test 1: " + Arrays.toString(searchRange(arr1, 8)));

        // target not in array
        int[] arr2 = {5, 7, 7, 8, 8, 10};
        System.out.println("Test 2: " + Arrays.toString(searchRange(arr2, 6)));

        // single element matches
        int[] arr3 = {5};
        System.out.println("Test 3: " + Arrays.toString(searchRange(arr3, 5)));
    }
}