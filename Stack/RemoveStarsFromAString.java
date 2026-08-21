// Problem: Removing Stars From a String
// Difficulty: Medium
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/removing-stars-from-a-string/

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveStarsFromAString {

    public String removeStars(String s) {

        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '*') {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (st.size() > 0) {
            sb.append(st.pop());
        }

        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {

        RemoveStarsFromAString solution =
                new RemoveStarsFromAString();

        // Test 1: LeetCode example
        String test1 = "leet**cod*e";

        // Test 2: LeetCode example
        String test2 = "erase*****";

        // Test 3: edge case
        String test3 = "abc";

        System.out.println("Test 1: " + solution.removeStars(test1));
        System.out.println("Test 2: " + solution.removeStars(test2));
        System.out.println("Test 3: " + solution.removeStars(test3));
    }
}