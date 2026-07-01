// Problem: Container With Most Water
// Difficulty: Medium
// Topic: Arrays
// LeetCode Link: https://leetcode.com/problems/container-with-most-water/

public class ContainerWithMostWater {

    public int maxArea(int[] arr) {

        int ans = 0;
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {

            // current container
            int minVal = Math.min(arr[l], arr[r]);
            int area = minVal * (r - l);

            if (area > ans) {
                ans = area;
            }

            // move smaller height
            if (arr[l] > arr[r]) {
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        int[] test1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] test2 = {1, 1};
        int[] test3 = {5, 5}; // edge case

        System.out.println("Test 1: " + solution.maxArea(test1));
        System.out.println("Test 2: " + solution.maxArea(test2));
        System.out.println("Test 3: " + solution.maxArea(test3));
    }
}