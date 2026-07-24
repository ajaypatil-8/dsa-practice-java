// Problem: Valid Parentheses
// Difficulty: Easy
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // push opening bracket
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {

                if (st.isEmpty()) {
                    return false;
                }

                // check matching bracket
                if ((ch == ')' && st.peek() == '(') ||
                    (ch == '}' && st.peek() == '{') ||
                    (ch == ']' && st.peek() == '[')) {

                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        ValidParentheses solution = new ValidParentheses();

        // Test 1
        String test1 = "()";

        // Test 2
        String test2 = "()[]{}";

        // Test 3 (edge case)
        String test3 = "(]";

        System.out.println("Test 1: " + solution.isValid(test1));
        System.out.println("Test 2: " + solution.isValid(test2));
        System.out.println("Test 3: " + solution.isValid(test3));
    }
}