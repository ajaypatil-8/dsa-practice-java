// Problem: Number of Visible People in a Queue
// Difficulty: Hard
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/number-of-visible-people-in-a-queue/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NumberOfVisiblePeopleInAQueue {

    public int[] canSeePersonsCount(int[] arr) {

        if (arr.length == 1) {
            return new int[1];
        }

        int[] ans = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            int count = 0;

            if (st.isEmpty()) {
                ans[i] = 0;
            } else if (st.peek() >= arr[i]) {
                ans[i] = 1;
            } else {

                // remove shorter people
                while (st.size() > 0 && st.peek() < arr[i]) {
                    st.pop();
                    count++;
                }

                // one taller person is also visible
                if (st.size() > 0 && st.peek() >= arr[i]) {
                    count++;
                }

                ans[i] = count;
            }

            st.push(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        NumberOfVisiblePeopleInAQueue solution =
                new NumberOfVisiblePeopleInAQueue();

        int[] test1 = {10, 6, 8, 5, 11, 9};
        int[] test2 = {5, 1, 2, 3, 10};
        int[] test3 = {7}; // edge case

        System.out.println("Test 1: " +
                Arrays.toString(solution.canSeePersonsCount(test1)));

        System.out.println("Test 2: " +
                Arrays.toString(solution.canSeePersonsCount(test2)));

        System.out.println("Test 3: " +
                Arrays.toString(solution.canSeePersonsCount(test3)));
    }
}