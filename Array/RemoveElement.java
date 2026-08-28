// Problem: Remove Element
// Difficulty: Easy
// Topic: Array
// LeetCode Link: https://leetcode.com/problems/remove-element/

public class RemoveElement {

    public int removeElement(int[] arr, int val) {

        int count = 0;
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {

            // keep values that are not target
            if (arr[i] != val) {
                arr[idx] = arr[i];
                idx++;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        RemoveElement solution = new RemoveElement();

        // Test 1: LeetCode example
        int[] test1 = {3, 2, 2, 3};
        int val1 = 3;

        // Test 2: LeetCode example
        int[] test2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;

        // Test 3: edge case
        int[] test3 = {1, 1, 1};
        int val3 = 1;

        int count1 = solution.removeElement(test1, val1);
        int count2 = solution.removeElement(test2, val2);
        int count3 = solution.removeElement(test3, val3);

        System.out.println("Test 1: " + count1);
        System.out.println("Test 2: " + count2);
        System.out.println("Test 3: " + count3);
    }
}