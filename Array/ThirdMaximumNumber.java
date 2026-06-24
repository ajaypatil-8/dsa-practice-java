// Problem: Third Maximum Number
// Difficulty: Easy
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/third-maximum-number/

public class ThirdMaximumNumber {

    public int thirdMax(int[] arr) {

        Long max = null;
        Long max2 = null;
        Long max3 = null;

        for (int elem : arr) {

            // skip duplicates
            if ((max != null && max == elem) ||
                (max2 != null && max2 == elem) ||
                (max3 != null && max3 == elem)) {
                continue;
            }

            if (max == null || elem > max) {
                max3 = max2;
                max2 = max;
                max = (long) elem;
            } else if (max2 == null || elem > max2) {
                max3 = max2;
                max2 = (long) elem;
            } else if (max3 == null || elem > max3) {
                max3 = (long) elem;
            }
        }

        return max3 == null ? max.intValue() : max3.intValue();
    }

    public static void main(String[] args) {
        ThirdMaximumNumber solution = new ThirdMaximumNumber();

        int[] test1 = {3, 2, 1};
        int[] test2 = {1, 2};
        int[] test3 = {2, 2, 3, 1}; // edge case

        System.out.println("Test 1: " + solution.thirdMax(test1));
        System.out.println("Test 2: " + solution.thirdMax(test2));
        System.out.println("Test 3: " + solution.thirdMax(test3));
    }
}