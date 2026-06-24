// Problem: Contains Duplicate
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] arr) {

        Set<Integer> n = new HashSet<>();

        for (int elem : arr) {

            // duplicate found
            if (!n.add(elem)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {1, 2, 3, 4};
        int[] test3 = {1}; // edge case

        System.out.println("Test 1: " + solution.containsDuplicate(test1));
        System.out.println("Test 2: " + solution.containsDuplicate(test2));
        System.out.println("Test 3: " + solution.containsDuplicate(test3));
    }
}