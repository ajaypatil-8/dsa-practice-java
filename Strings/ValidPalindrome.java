// Problem: Valid Palindrome
// Difficulty: Easy
// Topic: Strings
// LeetCode Link: https://leetcode.com/problems/valid-palindrome/

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // skip non-alphanumeric chars
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare ignoring case
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        String test3 = " "; // edge case

        System.out.println("Test 1: " + solution.isPalindrome(test1));
        System.out.println("Test 2: " + solution.isPalindrome(test2));
        System.out.println("Test 3: " + solution.isPalindrome(test3));
    }
}