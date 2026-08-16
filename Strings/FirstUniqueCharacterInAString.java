// Problem: First Unique Character in a String
// Difficulty: Easy
// Topic: String
// LeetCode Link: https://leetcode.com/problems/first-unique-character-in-a-string/

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        FirstUniqueCharacterInAString solution =
                new FirstUniqueCharacterInAString();

        // Test 1: LeetCode example
        String test1 = "leetcode";

        // Test 2: LeetCode example
        String test2 = "loveleetcode";

        // Test 3: edge case
        String test3 = "aabb";

        System.out.println("Test 1: " + solution.firstUniqChar(test1));
        System.out.println("Test 2: " + solution.firstUniqChar(test2));
        System.out.println("Test 3: " + solution.firstUniqChar(test3));
    }
}