// Problem: Next Greater Element II
// Difficulty: Medium
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/next-greater-element-ii/

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] arr) {

        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        // preload stack for circular array
        for (int i = arr.length - 1; i >= 0; i--) {
            st.push(arr[i]);
        }

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] < st.peek()) {
                ans[i] = st.peek();
                st.push(arr[i]);
            } else {

                while (!st.isEmpty() && st.peek() <= arr[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = st.peek();
                }

                st.push(arr[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        NextGreaterElementII solution = new NextGreaterElementII();

        int[] test1 = {1, 2, 1};
        int[] test2 = {1, 2, 3, 4, 3};
        int[] test3 = {5}; // edge case

        System.out.println("Test 1: " +
                Arrays.toString(solution.nextGreaterElements(test1)));

        System.out.println("Test 2: " +
                Arrays.toString(solution.nextGreaterElements(test2)));

        System.out.println("Test 3: " +
                Arrays.toString(solution.nextGreaterElements(test3)));
    }
}