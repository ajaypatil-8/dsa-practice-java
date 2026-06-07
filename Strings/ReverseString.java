// Problem: Reverse a String
// Difficulty: Easy
// Topic: Strings
// GFG Link: https://www.geeksforgeeks.org/problems/reverse-a-string/1
// Leetcode Link: https://leetcode.com/problems/reverse-string/

public class ReverseString {

    static String reverseString(String s) {
        char str[] = s.toCharArray();
        int i = 0, j = str.length - 1;

        // two pointers swapping from both ends
        while (i < j) {
            char temp = str[i];
            char temp1 = str[j];
            str[i] = temp1;
            str[j] = temp;
            i++;
            j--;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        // basic reverse
        System.out.println("Test 1: " + reverseString("hello"));

        // palindrome stays same
        System.out.println("Test 2: " + reverseString("madam"));

        // single character
        System.out.println("Test 3: " + reverseString("a"));
    }
}