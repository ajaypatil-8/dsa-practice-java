// Problem: Reverse Integer
// Difficulty: Medium
// Topic: Math
// LeetCode Link: https://leetcode.com/problems/reverse-integer/

public class ReverseInteger {

    public int reverse(int x) {

        int ans = 0;

        while (x != 0) {

            int digit = x % 10;

            // overflow check
            if (ans > Integer.MAX_VALUE / 10 ||
                (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // underflow check
            if (ans < Integer.MIN_VALUE / 10 ||
                (ans == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            ans = ans * 10 + digit;

            x /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();

        int test1 = 123;
        int test2 = -123;
        int test3 = 1534236469; // edge case (overflow)

        System.out.println("Test 1: " + solution.reverse(test1));
        System.out.println("Test 2: " + solution.reverse(test2));
        System.out.println("Test 3: " + solution.reverse(test3));
    }
}