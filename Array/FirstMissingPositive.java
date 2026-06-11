// Problem: First Missing Positive
// Difficulty: Hard
// Topic: Arrays, Cyclic Sort
// LeetCode Link: https://leetcode.com/problems/first-missing-positive/
// GFG Link: https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1

public class FirstMissingPositive {

    private void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int firstMissingPositive(int[] arr) {
        int i = 0;
        int n = arr.length;

        // place numbers at their correct index
        while (i < n) {
            if (arr[i] > n || arr[i] <= 0 ||
                arr[i] == arr[arr[i] - 1] ||
                arr[i] == i + 1) {
                i++;
            } else {
                swap(i, arr[i] - 1, arr);
            }
        }

        // first mismatch is the answer
        for (i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();

        int[] test1 = {1, 2, 0};
        int[] test2 = {3, 4, -1, 1};
        int[] test3 = {1}; // edge case

        System.out.println("Test 1: " + solution.firstMissingPositive(test1));
        System.out.println("Test 2: " + solution.firstMissingPositive(test2));
        System.out.println("Test 3: " + solution.firstMissingPositive(test3));
    }
}