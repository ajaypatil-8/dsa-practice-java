// Problem: Find the Difference
// Difficulty: Easy
// Topic: String
// LeetCode Link: https://leetcode.com/problems/find-the-difference/

import java.util.HashMap;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        char a = 'a';

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if ((!map.containsKey(ch)) ||
                (map.containsKey(ch) && map.get(ch) == 0)) {

                a = ch;
                return a;

            } else if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        return a;
    }

    public static void main(String[] args) {

        FindTheDifference solution = new FindTheDifference();

        // Test 1: LeetCode example
        String s1 = "abcd";
        String t1 = "abcde";

        // Test 2: LeetCode example
        String s2 = "";
        String t2 = "y";

        // Test 3: edge case
        String s3 = "a";
        String t3 = "aa";

        System.out.println("Test 1: " + solution.findTheDifference(s1, t1));
        System.out.println("Test 2: " + solution.findTheDifference(s2, t2));
        System.out.println("Test 3: " + solution.findTheDifference(s3, t3));
    }
}