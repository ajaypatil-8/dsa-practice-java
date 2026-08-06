// Problem: Largest Rectangle in Histogram
// Difficulty: Hard
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] arr) {

        int[] pse = new int[arr.length];
        int[] nse = new int[arr.length];

        Deque<Integer> st = new ArrayDeque<>();

        // previous smaller element
        for (int i = 0; i < arr.length; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                pse[i] = st.peek();
            } else {
                pse[i] = -1;
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        // next smaller element
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                nse[i] = st.peek();
            } else {
                nse[i] = arr.length;
            }

            st.push(i);
        }

        int maxArea = 0;

        // check every bar
        for (int i = 0; i < arr.length; i++) {

            int area = arr[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        LargestRectangleInHistogram solution =
                new LargestRectangleInHistogram();

        int[] test1 = {2, 1, 5, 6, 2, 3};
        int[] test2 = {2, 4};
        int[] test3 = {5}; // edge case

        System.out.println("Test 1: " + solution.largestRectangleArea(test1));
        System.out.println("Test 2: " + solution.largestRectangleArea(test2));
        System.out.println("Test 3: " + solution.largestRectangleArea(test3));
    }
}