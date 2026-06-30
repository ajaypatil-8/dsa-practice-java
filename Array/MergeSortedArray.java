// Problem: Merge Sorted Array
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/merge-sorted-array/

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int j = 0;

        // copy nums2 into nums1
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j];
            j++;
        }

        // sort the merged array
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        int[] test1Nums1 = {1, 2, 3, 0, 0, 0};
        int[] test1Nums2 = {2, 5, 6};

        int[] test2Nums1 = {1};
        int[] test2Nums2 = {};

        int[] test3Nums1 = {0};
        int[] test3Nums2 = {1}; // edge case

        solution.merge(test1Nums1, 3, test1Nums2, 3);
        solution.merge(test2Nums1, 1, test2Nums2, 0);
        solution.merge(test3Nums1, 0, test3Nums2, 1);

        System.out.println("Test 1: " + Arrays.toString(test1Nums1));
        System.out.println("Test 2: " + Arrays.toString(test2Nums1));
        System.out.println("Test 3: " + Arrays.toString(test3Nums1));
    }
}