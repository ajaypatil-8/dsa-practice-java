// Problem: Remove All Adjacent Duplicates In String
// Difficulty: Easy
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // remove adjacent duplicate
            if (!st.isEmpty() && ch == st.peek()) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        // build answer
        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        RemoveAllAdjacentDuplicatesInString solution =
                new RemoveAllAdjacentDuplicatesInString();

        String test1 = "abbaca";
        String test2 = "azxxzy";
        String test3 = "a"; // edge case

        System.out.println("Test 1: " + solution.removeDuplicates(test1));
        System.out.println("Test 2: " + solution.removeDuplicates(test2));
        System.out.println("Test 3: " + solution.removeDuplicates(test3));
    }
}