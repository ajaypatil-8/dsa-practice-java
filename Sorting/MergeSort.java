// Problem: Sort an Array
// Difficulty: Medium
// Topic: Sorting
// LeetCode Link: https://leetcode.com/problems/sort-an-array/
// GFG Link:

public class MergeSort {

    public int[] sortArray(int[] arr) {
        int n = arr.length;

        // already sorted
        if (n == 1) return arr;

        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];

        // split array
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = arr[idx++];
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = arr[idx++];
        }

        // sort both halves
        sortArray(a);
        sortArray(b);

        // merge back
        merge(a, b, arr);

        return arr;
    }

    public void merge(int[] a, int[] b, int[] ans) {
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                ans[idx++] = a[i++];
            } else {
                ans[idx++] = b[j++];
            }
        }

        while (i < a.length) {
            ans[idx++] = a[i++];
        }

        while (j < b.length) {
            ans[idx++] = b[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();

        int[] test1 = {5, 2, 3, 1};
        int[] test2 = {5, 1, 1, 2, 0, 0};
        int[] test3 = {1}; // edge case

        System.out.println("Test 1:");
        printArray(solution.sortArray(test1));

        System.out.println("Test 2:");
        printArray(solution.sortArray(test2));

        System.out.println("Test 3:");
        printArray(solution.sortArray(test3));
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}