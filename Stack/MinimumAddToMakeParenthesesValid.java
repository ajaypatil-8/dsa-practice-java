// Problem: Minimum Add to Make Parentheses Valid
// Difficulty: Medium
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == ')' && stack.peek() == ')') {
                stack.push(c);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {

        MinimumAddToMakeParenthesesValid solution =
                new MinimumAddToMakeParenthesesValid();

        // Test 1: LeetCode example
        String test1 = "())";

        // Test 2: LeetCode example
        String test2 = "(((";

        // Test 3: edge case
        String test3 = "";

        System.out.println("Test 1: " + solution.minAddToMakeValid(test1));
        System.out.println("Test 2: " + solution.minAddToMakeValid(test2));
        System.out.println("Test 3: " + solution.minAddToMakeValid(test3));
    }
}