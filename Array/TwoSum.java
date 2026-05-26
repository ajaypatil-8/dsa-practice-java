// Problem: Two Sum - Pair with Given Sum
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/key-pair5616/1

import java.util.HashSet;

public class TwoSum {

    static boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // check if the other half of target is already seen
            int complement = target - arr[i];
            if (set.contains(complement)) {
                return true;
            }
            set.add(arr[i]);
        }
        // no pair found
        return false;
    }

    public static void main(String[] args) {
        // pair 3+4 = 7 exists
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        System.out.println("Test 1: " + twoSum(arr1, 7));

        // no pair adds up to 100
        int[] arr2 = {1, 2, 4, 3, 6};
        System.out.println("Test 2: " + twoSum(arr2, 100));

        // single element, no pair possible
        int[] arr3 = {5};
        System.out.println("Test 3: " + twoSum(arr3, 10));
    }
}