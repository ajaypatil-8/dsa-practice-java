// Problem: Anagram
// Difficulty: Easy
// Topic: Strings
// GFG Link: https://www.geeksforgeeks.org/problems/anagram-1587115620/1
// Leetcode Link: https://leetcode.com/problems/valid-anagram/

import java.util.Arrays;

public class Anagram {

    static boolean isAnagram(String s, String t) {
        // different lengths cant be anagram
        if (s.length() != t.length()) return false;

        char a[] = s.toCharArray();
        char b[] = t.toCharArray();

        // sort both and compare
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // valid anagram
        System.out.println("Test 1: " + isAnagram("anagram", "nagaram"));

        // not an anagram
        System.out.println("Test 2: " + isAnagram("rat", "car"));

        // single same character
        System.out.println("Test 3: " + isAnagram("a", "a"));
    }
}