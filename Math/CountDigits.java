// Problem: Count Digits
// Difficulty: Easy
// Topic: Math
// LeetCode Link: https://leetcode.com/problems/count-the-digits-that-divide-a-number/

public class CountDigits {

    public int countDigits(int num) {

        int n = num;
        int count = 0;

        while (n != 0) {

            int last = n % 10;

            // skip zero digits
            if (last != 0 && num % last == 0) {
                count++;
            }

            n = n / 10;
        }

        return count;
    }

    public static void main(String[] args) {

        CountDigits solution = new CountDigits();

        // Test 1: LeetCode example
        int test1 = 7;

        // Test 2: LeetCode example
        int test2 = 121;

        // Test 3: edge case
        int test3 = 100;

        System.out.println("Test 1: " + solution.countDigits(test1));
        System.out.println("Test 2: " + solution.countDigits(test2));
        System.out.println("Test 3: " + solution.countDigits(test3));
    }
}