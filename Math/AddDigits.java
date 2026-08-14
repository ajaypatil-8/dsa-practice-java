// Problem: Add Digits
// Difficulty: Easy
// Topic: Math
// LeetCode Link: https://leetcode.com/problems/add-digits/

public class AddDigits {

    public int addDigits(int num) {

        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }
}