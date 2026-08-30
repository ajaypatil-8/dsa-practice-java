// Problem: Majority Element
// Difficulty: Easy
// Topic: Array
// LeetCode Link: https://leetcode.com/problems/majority-element/

import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int elem : arr) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }

        for (int elem : map.keySet()) {

            int freq = map.get(elem);

            if (freq > arr.length / 2) {
                return elem;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        MajorityElement solution = new MajorityElement();

        // Test 1: LeetCode example
        int[] test1 = {3, 2, 3};

        // Test 2: LeetCode example
        int[] test2 = {2, 2, 1, 1, 1, 2, 2};

        // Test 3: all same
        int[] test3 = {5, 5, 5, 5};

        System.out.println("Test 1: " + solution.majorityElement(test1));
        System.out.println("Test 2: " + solution.majorityElement(test2));
        System.out.println("Test 3: " + solution.majorityElement(test3));
    }
}