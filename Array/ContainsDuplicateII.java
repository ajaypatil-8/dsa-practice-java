// Problem: Contains Duplicate II
// Difficulty: Easy
// Topic: Array
// LeetCode Link: https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashSet;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] arr, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            if (set.contains(arr[i])) {
                return true;
            }

            set.add(arr[i]);

            if (set.size() > k) {
                set.remove(arr[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ContainsDuplicateII solution = new ContainsDuplicateII();

        // Test 1
        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1: " +
                solution.containsNearbyDuplicate(test1, 3));

        // Test 2
        int[] test2 = {1, 0, 1, 1};
        System.out.println("Test 2: " +
                solution.containsNearbyDuplicate(test2, 1));

        // Test 3
        int[] test3 = {1, 2, 3, 1, 2, 3};
        System.out.println("Test 3: " +
                solution.containsNearbyDuplicate(test3, 2));
    }
}