// Problem: Baseball Game
// Difficulty: Easy
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/baseball-game/

import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] arr) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            String s = arr[i];

            if (s.equals("C") && st.size() > 0) {
                st.pop();
            } else if (s.equals("D")) {
                st.push(st.peek() * 2);
            } else if (s.equals("+")) {

                // use previous two scores
                int top = st.pop();
                int secondTop = st.peek();

                st.push(top);
                st.push(top + secondTop);

            } else {
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;

        // add all scores
        while (st.size() > 0) {
            sum += st.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        BaseballGame solution = new BaseballGame();

        String[] test1 = {"5", "2", "C", "D", "+"};
        String[] test2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        String[] test3 = {"5"}; // edge case

        System.out.println("Test 1: " + solution.calPoints(test1));
        System.out.println("Test 2: " + solution.calPoints(test2));
        System.out.println("Test 3: " + solution.calPoints(test3));
    }
}